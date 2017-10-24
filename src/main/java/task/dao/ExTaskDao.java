package task.dao;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import task.db.Tables;
import task.db.tables.daos.TaskDao;
import task.db.tables.pojos.Employee;
import task.db.tables.pojos.Task;

import java.util.List;
import java.util.Set;

/**
 * Created by aleksandr on 21.10.2017.
 */
@Repository
public class ExTaskDao extends TaskDao {
    private final DSLContext dsl;

    @Autowired
    public ExTaskDao(DSLContext dsl) {
        super(dsl.configuration());

        this.dsl = dsl;
    }

    public void insert (Task task, Set<String> assigneeUsernames) {
        super.insert(task);

        assigneeUsernames.stream()
                .forEach(p -> dsl.insertInto(Tables.TASK_EMPLOYEE)
                        .columns(Tables.TASK_EMPLOYEE.TASK_ID, Tables.TASK_EMPLOYEE.USERNAME)
                        .values(task.getId(), p).execute());

    }

    public void update (Task task, Set<String> assigneeUsernames) {
        super.update(task);

        dsl.delete(Tables.TASK_EMPLOYEE)
                .where(Tables.TASK_EMPLOYEE.TASK_ID.equal(task.getId()))
                .execute();
        assigneeUsernames.stream()
                .forEach(p -> dsl.insertInto(Tables.TASK_EMPLOYEE)
                        .columns(Tables.TASK_EMPLOYEE.TASK_ID, Tables.TASK_EMPLOYEE.USERNAME)
                        .values(task.getId(), p).execute());
    }

    public List<Employee> getAssigneesUsernames (Long taskId) {
        return dsl
                .select()
                .from(Tables.EMPLOYEE)
                .where(Tables.EMPLOYEE.USERNAME.in(dsl.select()
                        .from(Tables.TASK_EMPLOYEE)
                        .where(Tables.TASK_EMPLOYEE.TASK_ID.equal(taskId))
                        .fetch(Tables.TASK_EMPLOYEE.USERNAME)))
                .fetch()
                .map(p -> new Employee(
                        p.get(Tables.EMPLOYEE.USERNAME),
                        p.get(Tables.EMPLOYEE.EMAIL),
                        p.get(Tables.EMPLOYEE.NAME)));
    }
}
