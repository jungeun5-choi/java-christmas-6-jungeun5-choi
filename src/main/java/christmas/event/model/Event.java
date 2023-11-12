package christmas.event.model;

import christmas.util.enumerator.EventType;

public record Event(
        EventType eventType,
        String name,
        int discount,
        int discountIncreasePerDay,
        String reward,
        int endDay) {

}