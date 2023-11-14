package christmas.order.repository;

import christmas.order.model.OrderData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    private static final int DEFAULT = 0;

    private List<OrderData> orderData = new ArrayList<>();
    private List<Integer> totalAmounts = new ArrayList<>();

    public void save(OrderData orderData, int totalAmount) {
        this.orderData.add(orderData);
        this.totalAmounts.add(totalAmount);
    }

    public OrderData findOrder() {
        return orderData.get(DEFAULT);
    }

    public int findVisitDay() {
        return findOrder().visitDay();
    }

    public Map<String, Integer> findOrderList() {
        return findOrder().orders();
    }

    public int findTotalAmount() {
        return totalAmounts.get(DEFAULT);
    }
}
