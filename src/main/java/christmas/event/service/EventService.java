package christmas.event.service;

import christmas.event.model.Event;
import christmas.event.model.EventData;
import christmas.common.enumerator.EventType;
import java.util.ArrayList;
import java.util.List;

public class EventService {
    private static final int DECEMBER_CHRISTMAS = 25;
    private static final int DECEMBER_LAST = 31;

    public Event createEvent() {
        List<EventData> eventData = new ArrayList<>();
        eventData.add(new EventData(EventType.CHRISTMAS_D_DAY, 1000, 100, "증정 없음", DECEMBER_CHRISTMAS));
        eventData.add(new EventData(EventType.WEEKDAY, 2023, 0, "증정 없음", DECEMBER_LAST));
        eventData.add(new EventData(EventType.WEEKEND, 2023, 0, "증정 없음", DECEMBER_LAST));
        eventData.add(new EventData(EventType.SPECIAL, 1000, 0, "증정 없음", DECEMBER_LAST));
        eventData.add(new EventData(EventType.REWARD, 25000, 0, "샴페인 1개 증정", DECEMBER_LAST));
        return new Event(eventData);
    }
}
