package christmas.event.repository;

import christmas.common.enumerator.EventType;
import christmas.event.model.EventData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventRepository {
    private List<EventData> eventData = new ArrayList<>();

    public void save(EventData eventData) {
        this.eventData.add(eventData);
    }

    public EventData findEventByType(EventType type) throws NullPointerException {
        for (EventData event : this.eventData) {
            if (Objects.equals(type, event.eventType())) {
                return event;
            }
        }
        throw new NullPointerException();
    }
}
