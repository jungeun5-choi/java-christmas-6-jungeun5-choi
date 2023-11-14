package christmas.event.model;

import christmas.common.enumerator.EventType;

public record EventData(
        EventType eventType,
        String name,
        int endDay,
        int defaultDiscount,
        boolean hasReward) {
}