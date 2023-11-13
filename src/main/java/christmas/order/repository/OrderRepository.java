package christmas.order.repository;

import christmas.order.model.OrderData;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static final int DEFAULT = 0;
    private final List<OrderData> orderData = new ArrayList<>();

    public void save(OrderData orderData) {
        this.orderData.add(orderData);
    }

    public OrderData findOrder() {
        return orderData.get(DEFAULT);
    }
}
