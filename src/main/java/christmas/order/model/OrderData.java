package christmas.order.model;

import java.util.Map;

public record OrderData(
        int visitDay,
        Map<String, Integer> orders,
        int totalAmount) {
}
