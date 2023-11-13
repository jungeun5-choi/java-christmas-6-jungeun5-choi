package christmas.order.model;

import java.util.Map;

public class Order {
    private final int visitDay;
    private final Map<String, Integer> orders;

    public Order(int visitDay, Map<String, Integer> orders) {
        this.visitDay = visitDay;
        this.orders = orders;
    }

    public Map<String, Integer> getOrders() {
        return orders;
    }
}
