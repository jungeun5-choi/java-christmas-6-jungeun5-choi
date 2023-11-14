package christmas.event.repository;

import christmas.event.model.EventData;
import java.util.ArrayList;
import java.util.List;

public class EventRepository {
    private List<EventData> eventData = new ArrayList<>();

    public void save(EventData eventData) {
        this.eventData.add(eventData);
    }
}
