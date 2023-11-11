package christmas.event.controller;

import christmas.event.domain.Event;
import christmas.event.domain.EventPlan;
import christmas.util.Controllable;
import christmas.util.enumerator.EventType;
import java.util.ArrayList;
import java.util.List;

public class InitializeEventController implements Controllable {
    private static final int DECEMBER_FIRST = 1;
    private static final int DECEMBER_CHRISTMAS = 25;
    private static final int DECEMBER_LAST = 31;


    @Override
    public void process() {
        EventPlan eventPlan = new EventPlan(initialize());
        for (Event event : eventPlan.getEvents()) {
            System.out.print(event.eventType());
            System.out.print("\t/\t" + event.name());
            System.out.print("\t/\t" + event.discount());
            System.out.print("\t/\t" + event.discountIncreasePerDay());
            System.out.print("\t/\t" + event.reward());
            System.out.print("\t/\t" + event.endDay());
            System.out.println();
        }
    }

    private List<Event> initialize() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(EventType.CHRISTMAS_DDAY, "크리스마스 디데이 할인", 1000, 100, "증정 없음", DECEMBER_CHRISTMAS));
        events.add(new Event(EventType.WEEKDAY, "평일 할인", 2023, 0, "증정 없음", DECEMBER_LAST));
        events.add(new Event(EventType.WEEKEND, "주말 할인", 2023, 0, "증정 없음", DECEMBER_LAST));
        events.add(new Event(EventType.SPECIAL, "특별 할인", 1000, 0, "증정 없음", DECEMBER_LAST));
        events.add(new Event(EventType.REWARD, "증정 이벤트", 25000, 0, "샴페인 1개 증정", DECEMBER_LAST));
        return events;
    }
}