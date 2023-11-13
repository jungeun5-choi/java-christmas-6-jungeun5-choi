package christmas.order.dto;

import java.util.Map;

public class OrderDto {
    private int visitDay;
    private Map<String, Integer> orders;
    private int totalOrderAmount;

    public OrderDto(int visitDay, Map<String, Integer> orders, int totalOrderAmount) {
        this.visitDay = visitDay;
        this.orders = orders;
        this.totalOrderAmount = totalOrderAmount;
    }

    public int getVisitDay() {
        return visitDay;
    }

    public Map<String, Integer> getOrders() {
        return orders;
    }

    public int getTotalOrderAmount() {
        return totalOrderAmount;
    }
}
