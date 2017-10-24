package task.sse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by aleksandr on 22.10.2017.
 */

@Component
@Scope("singleton")
public class EventPublisher {
    private static List<SseEmitter> sses = Collections.synchronizedList(new ArrayList<>());

    public void pub(PushNotification message) {
        sses.forEach((sse) -> {
            try {
                sse.send(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public SseEmitter addListener() {
        final SseEmitter emitter = new SseEmitter();

        emitter.onCompletion(() -> {
            synchronized (this.sses) {
                this.sses.remove(emitter);
            }
        });

        emitter.onTimeout(()-> {
            emitter.complete();
        });

        sses.add(emitter);

        return emitter;
    }
/*
    public void removeListener(long id) {
        sses.remove(id);
    }
*/
    public long count() {
        return sses.size();
    }
}
