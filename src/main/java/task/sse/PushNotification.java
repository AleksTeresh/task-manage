package task.sse;

/**
 * Created by aleksandr on 23.10.2017.
 */
public class PushNotification {
    private Object object;
    private PushType type;
    private ActionInitiator initiator;

    public PushNotification(PushType type) {
        this(type, null);
    }

    public PushNotification(PushType type, Object object) {
        this(type, object, null);
    }

    public PushNotification(PushType type, Object object, ActionInitiator initiator) {
        this.type = type;
        this.object = object;
        this.initiator = initiator;
    }

    public void setInitiator(ActionInitiator initiator) {
        this.initiator = initiator;
    }
    public ActionInitiator getInitiator() {
        return this.initiator;
    }

    public void setPushType(PushType type) {
        this.type = type;
    }
    public PushType getPushType() {
        return this.type;
    }

    public void setObject(Object object) {
        this.object = object;
    }
    public Object getObject() {
        return this.object;
    }
}

