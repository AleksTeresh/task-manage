package task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.controllers.utils.UserUtils;
import task.dao.ExStoreSectionDao;
import task.dao.ExTaskDao;
import task.dao.ExUserDao;
import task.db.enums.TaskStatus;
import task.db.tables.pojos.Task;
import task.representations.EmployeeView;
import task.representations.StoreSectionView;
import task.representations.TaskReq;
import task.representations.TaskView;
import task.sse.ActionInitiator;
import task.sse.EventPublisher;
import task.sse.PushNotification;
import task.sse.PushType;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Created by aleksandr on 21.10.2017.
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    private final ExTaskDao taskDao;
    private final ExStoreSectionDao sectionDao;
    private final ExUserDao userDao;
    private final UserUtils userUtils;
    private final EventPublisher publisher;

    @Autowired
    public TaskController(
            ExTaskDao taskDao,
            ExStoreSectionDao sectionDao,
            ExUserDao userDao,
            UserUtils userUtils,
            EventPublisher publisher
    ) {
        this.taskDao = taskDao;
        this.sectionDao = sectionDao;
        this.userDao = userDao;

        this.userUtils = userUtils;
        this.publisher = publisher;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<TaskView> getTasks(
            @RequestParam(value = "includeCompleted", defaultValue = "true") boolean includeCompleted,
            @RequestParam(value = "templates", defaultValue = "false") boolean templates
    ) {
        return taskDao.fetchByTemplate(templates).stream()
                .filter(p -> includeCompleted || p.getStatus() != TaskStatus.done)
                .map(p -> TaskView.fromEntity(
                        p,
                        StoreSectionView.fromEntity(sectionDao.fetchOneById(p.getSectionId())),
                        taskDao.getAssigneesUsernames(p.getId())
                                .stream()
                                .map(s -> EmployeeView.fromEntity(
                                        s,
                                        new ArrayList<TaskView>(),
                                        userDao.fetchOneByUsername(s.getUsername()).getRank()
                                )).collect(Collectors.toSet())
                ))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public TaskView getTaskById(@PathVariable("id") Long id) {
        Task fetchedTask = taskDao.fetchOneById(id);
        StoreSectionView section = StoreSectionView.fromEntity(sectionDao.fetchOneById(fetchedTask.getSectionId()));

        return TaskView.fromEntity(
                fetchedTask,
                section,
                taskDao.getAssigneesUsernames(fetchedTask.getId())
                    .stream()
                    .map(s -> EmployeeView.fromEntity(
                            s,
                            new ArrayList<TaskView>(),
                            userDao.fetchOneByUsername(s.getUsername()).getRank()
                    )).collect(Collectors.toSet()));
    }

    @RequestMapping(method = RequestMethod.POST)
    public TaskView addTask(
            @RequestBody TaskReq task,
            HttpServletRequest request
    ) {
        long taskId = taskDao.count() + 1;
        taskDao.insert(
                fromRequest(task, userUtils.getAuthenticatedUser(request).getUsername(), taskId),
                task.getAssignees()
        );

        TaskView storedTask = getTaskById(taskId);

        publisher.pub(new PushNotification(
                PushType.CREATE,
                storedTask,
                new ActionInitiator(userUtils.getAuthenticatedUser(request).getUsername())
        ));

        return storedTask;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public TaskView updateTask(
            @PathVariable("id") Long id,
            @RequestBody TaskReq task,
            HttpServletRequest request
    ) {
        taskDao.update(
                fromRequest(task, userUtils.getAuthenticatedUser(request).getUsername(), id),
                task.getAssignees()
        );

        TaskView storedTask = getTaskById(id);

        publisher.pub(new PushNotification(
                PushType.UPDATE,
                storedTask,
                new ActionInitiator(userUtils.getAuthenticatedUser(request).getUsername())
        ));

        return storedTask;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deleteTask(
            @PathVariable("id") Long id,
            HttpServletRequest request
    ) {
        if (taskDao.existsById(id)) {
            taskDao.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        publisher.pub(new PushNotification(
                PushType.DELETE,
                id,
                new ActionInitiator(userUtils.getAuthenticatedUser(request).getUsername())
        ));

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    private Task fromRequest(TaskReq request, String creatorName, long id) {
        TaskStatus status;

        switch (request.getStatus()) {
            case NEW:
                status = TaskStatus.new_;
                break;

            case INPROGRESS:
                status = TaskStatus.in_progress;
                break;

            case DONE:
                status = TaskStatus.done;
                break;

            default:
                status = TaskStatus.new_;
        }

        return new Task(
                id,
                request.getName(),
                request.getDescription(),
                status,
                request.isUrgent(),
                request.isAppeal(),
                request.isTemplate(),
                request.getSection(),
                new Timestamp(new Date().getTime()),
                new Timestamp(request.getDueTime()),
                creatorName
        );
    }
}