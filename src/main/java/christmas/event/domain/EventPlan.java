package christmas.event.domain;

import java.util.List;

public class EventPlan {
    private final List<Event> events;

    public EventPlan(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }
}
