package christmas.order.service;

import christmas.order.model.Order;
import java.util.Map;

public class OrderService {
    public Order save(int visitDay, Map<String, Integer> orders) {
        return new Order(visitDay, orders);
    }
}
