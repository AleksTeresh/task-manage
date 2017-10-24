package task.representations;

import task.representations.enums.Status;

import java.util.Set;

/**
 * Created by aleksandr on 22.10.2017.
 */
public class TaskReq {
    private String name;
    private String description;
    private Status status;
    private boolean urgent;
    private boolean appeal;
    private long section;
    private long dueTime;
    private Set<String> assignees;
    private boolean template;

    public TaskReq() {

    }
/*
    public TaskReq(
            @JsonProperty Long id,
            @JsonProperty String name,
            @JsonProperty String description,
            @JsonProperty long creationTime,
            @JsonProperty long dueTime,
            @JsonProperty Status status,
            @JsonProperty boolean urgent,
            @JsonProperty boolean appeal,
            @JsonProperty long section,
            @JsonProperty Set<String> assignees
    ) {
        this.name = name;
        this.description = description;
        this.status = Status.NEW;
        this.urgent = false;
        this.appeal = false;
        this.template = false;
        this.section = section;
        this.dueTime = dueTime;
        this.assignees = assignees;
    }
*/
    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) { this.description = description; }

    public long getSection() {
        return this.section;
    }
    public void setSection(long section) { this.section = section; }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) { this.status = status; }

    public long getDueTime() {
        return this.dueTime;
    }
    public void setDueTime(long dueTime) { this.dueTime = dueTime; }

    public boolean isUrgent() {
        return this.urgent;
    }
    public void setUrgent(boolean urgent) { this.urgent = urgent; }

    public boolean isAppeal() {
        return this.appeal;
    }
    public void setAppeal(boolean appeal) { this.appeal = appeal; }

    public Set<String> getAssignees() {
        return this.assignees;
    }
    public void setAssignees(Set<String> assignees) {
        this.assignees = assignees;
    }

    public boolean isTemplate() {
        return this.template;
    }
    public void setTemplate(boolean template) { this.template = template; }
}
