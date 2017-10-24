/*
 * This file is generated by jOOQ.
*/
package task.db.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TaskEmployee implements Serializable {

    private static final long serialVersionUID = 1481667281;

    private Long   taskId;
    private String username;

    public TaskEmployee() {}

    public TaskEmployee(TaskEmployee value) {
        this.taskId = value.taskId;
        this.username = value.username;
    }

    public TaskEmployee(
        Long   taskId,
        String username
    ) {
        this.taskId = taskId;
        this.username = username;
    }

    public Long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TaskEmployee (");

        sb.append(taskId);
        sb.append(", ").append(username);

        sb.append(")");
        return sb.toString();
    }
}