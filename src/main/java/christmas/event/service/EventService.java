package christmas.event.service;

import christmas.common.enumerator.EventType;
import christmas.event.model.EventData;
import christmas.event.repository.EventRepository;

public class EventService {
    private static final int DECEMBER_CHRISTMAS = 25;
    private static final int DECEMBER_LAST = 31;

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent() {
        eventRepository.save(new EventData(EventType.CHRISTMAS_D_DAY, 1000, 100, "증정 없음", DECEMBER_CHRISTMAS));
        eventRepository.save(new EventData(EventType.WEEKDAY, 2023, 0, "증정 없음", DECEMBER_LAST));
        eventRepository.save(new EventData(EventType.WEEKEND, 2023, 0, "증정 없음", DECEMBER_LAST));
        eventRepository.save(new EventData(EventType.SPECIAL, 1000, 0, "증정 없음", DECEMBER_LAST));
        eventRepository.save(new EventData(EventType.REWARD, 25000, 0, "샴페인 1개 증정", DECEMBER_LAST));
    }
}
