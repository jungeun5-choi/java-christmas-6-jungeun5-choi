package christmas.event.repository;

import christmas.common.enumerator.EventType;
import christmas.event.model.EventData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventRepository {
    private static List<EventData> eventData = new ArrayList<>();

    public void save(EventData eventData) {
        this.eventData.add(eventData);
    }

    public static EventData findEventByEventType(EventType type) throws NullPointerException {
        for (EventData event : eventData) {
            if (Objects.equals(type, event.eventType())) {
                return event;
            }
        }
        throw new NullPointerException();
    }

    public static int findEndDayByEventType(EventType type) {
        return findEventByEventType(type).endDay();
    }

    public int findDefaultDiscountByEventType(EventType type) {
        return findEventByEventType(type).defaultDiscount();
    }
}
