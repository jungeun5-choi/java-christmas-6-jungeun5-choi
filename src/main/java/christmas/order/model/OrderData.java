package christmas.order.model;

import christmas.common.validator.OrderValidator;
import java.util.Map;

public record OrderData(int visitDay, Map<String, Integer> orders) {
    public OrderData {
        new OrderValidator().validate(visitDay, orders);
    }
}