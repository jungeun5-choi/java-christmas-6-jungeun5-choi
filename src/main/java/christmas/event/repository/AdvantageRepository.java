package christmas.event.repository;

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
        discounts.put(eventData.type(), discount);
    }

    public EventData findAdvantageByEventType(EventType type) {
        for (EventData event : advantages) {
            if (Objects.equals(type, event.type())) {
                return event;
            }
        }
        return null;
    }

    public int findDiscountByEventType(EventType type) {
        if (!discounts.containsKey(type)) {
            return 0;
        }
        return discounts.get(type);
    }

    public List<EventData> findAllAdvantages() {
        return advantages;
    }

    public Map<EventType, Integer> findAllDiscounts() {
        return discounts;
    }

    public int calculateTotalDiscountAmount() {
        return findAllDiscounts().values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
