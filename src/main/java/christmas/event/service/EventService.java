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
        eventRepository.save(new EventData(EventType.CHRISTMAS_D_DAY, "크리스마스 디데이 할인", DECEMBER_CHRISTMAS, 1000, false));
        eventRepository.save(new EventData(EventType.WEEKDAY, "평일 할인", DECEMBER_LAST, 2023, false));
        eventRepository.save(new EventData(EventType.WEEKEND, "주말 할인", DECEMBER_LAST, 2023, false));
        eventRepository.save(new EventData(EventType.SPECIAL, "특별 할인", DECEMBER_LAST, 1000, false));
        eventRepository.save(new EventData(EventType.REWARD, "증정 이벤트", DECEMBER_LAST, 25000, true));
    }
}
