package christmas.order.service;

import christmas.menu.repository.MenuRepository;
import christmas.order.dto.OrderDto;
import christmas.order.model.OrderData;
import christmas.order.repository.OrderRepository;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(int visitDay, Map<String, Integer> orders) {
        OrderData order = new OrderData(visitDay, orders);
        int totalAmount = getTotalAmount(orders);
        orderRepository.save(order, totalAmount);
    }

    public OrderDto present() {
        return convertToDto();
    }

    private OrderDto convertToDto() {
        int visitDay = OrderRepository.findVisitDay();
        Map<String, Integer> orders = orderRepository.findOrderList();
        int totalAmount = OrderRepository.findTotalAmount();
        return new OrderDto(visitDay, orders, totalAmount);
    }

    private int getTotalAmount(Map<String, Integer> orders) {
        return orders.entrySet()
                .stream()
                .mapToInt(this::calculateAmount)
                .sum();
    }

    private int calculateAmount(Entry<String, Integer> orders) {
        int price = Objects.requireNonNull(MenuRepository.findMenuByName(orders.getKey())).price();
        return multiplyPerMenu(orders, price);
    }

    private int multiplyPerMenu(Entry<String, Integer> orders, int price) {
        return orders.getValue() * price;
    }
}
