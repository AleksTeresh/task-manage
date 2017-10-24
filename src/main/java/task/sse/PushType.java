package task.sse;

/**
 * Created by aleksandr on 23.10.2017.
 */
public enum PushType {
    CREATE("create"), UPDATE("update"), DELETE("delete");

    private String name;

    private PushType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

