package christmas.event.model;

import java.util.List;

public class Event {
    private final List<EventData> eventData;

    public Event(List<EventData> eventData) {
        this.eventData = eventData;
    }

    public List<EventData> getEvents() {
        return eventData;
    }
}
