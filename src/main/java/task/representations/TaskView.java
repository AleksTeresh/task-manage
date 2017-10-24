package task.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import task.db.tables.pojos.Task;
import task.representations.enums.Status;

import java.util.Date;
import java.util.Set;

/**
 * Created by aleksandr on 20.10.2017.
 */
public class TaskView {
    private final Long id;
    private final String name;
    private final String description;
    private final Status status;
    private final boolean urgent;
    private final boolean appeal;
    private final StoreSectionView section;
    private final long creationTime;
    private final long dueTime;
    private final Set<EmployeeView> assignees;
    private final boolean template;

    @JsonCreator
    public TaskView(
            @JsonProperty Long id,
            @JsonProperty String name,
            @JsonProperty String description,
            @JsonProperty long creationTime,
            @JsonProperty long dueTime,
            @JsonProperty Status status,
            @JsonProperty boolean urgent,
            @JsonProperty boolean appeal,
            @JsonProperty StoreSectionView section,
            @JsonProperty Set<EmployeeView> assignees
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationTime = new Date().getTime();
        this.status = Status.NEW;
        this.urgent = false;
        this.appeal = false;
        this.template = false;
        this.section = section;
        this.dueTime = dueTime;
        this.assignees = assignees;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public StoreSectionView getSection() {
        return this.section;
    }

    public Status getStatus() {
        return status;
    }

    public long getCreationTime() {
        return this.creationTime;
    }

    public long getDueTime() {
        return this.dueTime;
    }

    public boolean isUrgent() {
        return this.urgent;
    }

    public boolean isAppeal() {
        return this.appeal;
    }

    public Set<EmployeeView> getAssignees() {
        return this.assignees;
    }

    public boolean isTemplate() {
        return this.template;
    }

    public static TaskView fromEntity(Task task, StoreSectionView section, Set<EmployeeView> assignees) {
        Status status = Status.NEW;

        switch (task.getStatus()) {
            case done:
                status = Status.DONE;
                break;

            case in_progress:
                status = Status.INPROGRESS;
                break;

            default:
                status = Status.NEW;
        }

        return new TaskView(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getCreationTime().getTime(),
                task.getDuetime().getTime(),
                status,
                task.getUrgent(),
                task.getAppeal(),
                section,
                assignees
        );
    }
}
