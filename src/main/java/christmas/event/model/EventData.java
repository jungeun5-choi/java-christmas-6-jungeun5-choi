package christmas.event.model;

import christmas.common.enumerator.EventType;

public record EventData(
        EventType eventType,
        int discount,
        int discountIncreasePerDay,
        String reward,
        int endDay) {

}