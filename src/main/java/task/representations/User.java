package task.representations;

/**
 * Created by aleksandr on 21.10.2017.
 */
public class User {
    private final String username;
    private final String password;
    private final boolean enabled;

    public User(String username, String password, String email, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
