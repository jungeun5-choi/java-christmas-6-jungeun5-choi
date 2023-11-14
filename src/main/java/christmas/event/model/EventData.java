package christmas.event.model;

import christmas.common.enumerator.EventType;

public record EventData(
        EventType type,
        String name,
        int endDay,
        int defaultDiscount,
        boolean hasReward) {
}