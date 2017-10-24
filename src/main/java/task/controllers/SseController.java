package task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import task.sse.EventPublisher;

/**
 * Created by aleksandr on 22.10.2017.
 */

@RestController
public class SseController {
    private final EventPublisher publisher;
    // private final ReactivePublisher publisher;

    @Autowired
    public SseController(EventPublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping(name = "/sse")
    public SseEmitter subscribe() {
        return publisher.addListener();
    }
}
