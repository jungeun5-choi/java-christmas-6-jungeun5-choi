package christmas.eventPlanner.repository;

import christmas.common.enumerator.EventType;
import christmas.event.model.EventData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AdvantageRepository {
    private List<EventData> advantages = new ArrayList<>();
    private Map<EventType, Integer> discounts = new LinkedHashMap<>();

    public void save(EventData eventData, int discount) {
        advantages.add(eventData);
        discounts.put(eventData.eventType(), discount);
    }

    public EventData findAdvantageByEventType(EventType type) {
        for (EventData event : advantages) {
            if (Objects.equals(type, event.eventType())) {
                return event;
            }
        }
        return null;
    }

    public int findDiscountByEventType(EventType type) throws NullPointerException {
        if (!discounts.containsKey(type)) {
            throw new NullPointerException();
        }
        return discounts.get(type);
    }

    public List<EventData> findAllAdvantages() {
        return advantages;
    }

    public Map<EventType, Integer> findAllDiscounts() {
        return discounts;
    }
}
