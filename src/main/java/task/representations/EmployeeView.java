package task.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import task.db.enums.EmployeeRank;
import task.db.tables.pojos.Employee;
import task.representations.enums.Rank;

import java.util.List;

/**
 * Created by aleksandr on 21.10.2017.
 */
public class EmployeeView {

    private String username;
    private String name;
    private String email;
    private Rank rank;
    private List<TaskView> tasks;

    @JsonCreator
    public EmployeeView(
            @JsonProperty String username,
            @JsonProperty String email,
            @JsonProperty String name,
            @JsonProperty Rank rank,
            @JsonProperty List<TaskView> tasks
    ) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.rank = rank;
        this.tasks = tasks;
    }

    public String getUsername() { return this.username; }

    public Rank getRank() {
        return this.rank;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() { return this.email; }

    public List<TaskView> getTasks() {
        return this.tasks;
    }

    public static EmployeeView fromEntity(Employee employee, List<TaskView> tasks, EmployeeRank rank) {

        return new EmployeeView(
                employee.getUsername(),
                employee.getEmail(),
                employee.getName(),
                rank == EmployeeRank.manager
                ? Rank.MANAGER
                : Rank.WORKER,
                tasks
        );
    }
}