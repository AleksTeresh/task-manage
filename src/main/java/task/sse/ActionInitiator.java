package task.sse;

/**
 * Created by aleksandr on 23.10.2017.
 */
public class ActionInitiator {
    private String username;

    public ActionInitiator() {
        this(null);
    }

    public ActionInitiator(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}

