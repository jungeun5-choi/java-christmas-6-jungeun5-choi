package christmas.eventPlanner.service;

import christmas.common.enumerator.EventType;
import christmas.event.model.EventData;
import christmas.event.repository.EventRepository;
import christmas.eventPlanner.repository.EventPlannerRepository;
import christmas.menu.repository.MenuRepository;
import christmas.order.repository.OrderRepository;
import java.util.Map.Entry;
import java.util.Objects;

public class EventPlannerService {
    private final EventRepository eventRepository;
    private final OrderRepository orderRepository;
    private final EventPlannerRepository eventPlannerRepository;

    public EventPlannerService(EventRepository eventRepository, OrderRepository orderRepository,
                               EventPlannerRepository eventPlannerRepository) {
        this.eventRepository = eventRepository;
        this.orderRepository = orderRepository;
        this.eventPlannerRepository = eventPlannerRepository;
    }

    public void process() {
        processReward();
    }

    public boolean hasAdvantage(EventType type) {
        return Objects.nonNull(eventPlannerRepository.findEventByType(type));
    }

    private void processReward() {
        if (isSatisfiedReward()) {
            EventData event = findEvent(EventType.REWARD);
            eventPlannerRepository.save(event);
        }
    }

    private boolean isSatisfiedReward() {
        return orderRepository.findTotalAmount() >= 120000;
    }

    private EventData findEvent(EventType type) {
        return eventRepository.findEventByType(type);
    }
}
