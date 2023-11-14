package christmas.eventPlanner.repository;

import christmas.common.enumerator.EventType;
import christmas.event.model.EventData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventPlannerRepository {
    private List<EventData> eventPlanners = new ArrayList<>();

    public void save(EventData eventData) {
        eventPlanners.add(eventData);
    }

    public EventData findEventByType(EventType type) {
        for (EventData event : this.eventPlanners) {
            if (Objects.equals(type, event.eventType())) {
                return event;
            }
        }
        return null;
    }
}
