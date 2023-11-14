package christmas.order.repository;

import christmas.order.model.OrderData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderRepository {
    private static final int DEFAULT = 0;

    private static List<OrderData> orderData = new ArrayList<>();
    private static List<Integer> totalAmounts = new ArrayList<>();

    public void save(OrderData orderData, int totalAmount) {
        this.orderData.add(orderData);
        this.totalAmounts.add(totalAmount);
    }

    public static OrderData findOrder() {
        return orderData.get(DEFAULT);
    }

    public static int findVisitDay() {
        return findOrder().visitDay();
    }

    public Map<String, Integer> findOrderList() {
        return findOrder().orders();
    }

    public static int findTotalAmount() {
        return totalAmounts.get(DEFAULT);
    }

    public Set<String> findOrderMenuName() {
        return findOrder().orders().keySet();
    }
}
