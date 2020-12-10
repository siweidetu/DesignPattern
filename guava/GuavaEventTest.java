package DesignPattern.guava;

import com.google.common.eventbus.EventBus;

public class GuavaEventTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        GuavaEvent2 guavaEvent2 = new GuavaEvent2();
        eventBus.register(guavaEvent);
        eventBus.register(guavaEvent2);
        eventBus.post("Tom");
    }
}
