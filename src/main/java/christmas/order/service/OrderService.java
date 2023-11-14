package christmas.order.service;

import christmas.menu.repository.MenuRepository;
import christmas.order.dto.OrderDto;
import christmas.order.model.OrderData;
import christmas.order.repository.OrderRepository;
import java.util.Map;
import java.util.Map.Entry;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(int visitDay, Map<String, Integer> orders) {
        int totalAmount = getTotalAmount(orders);
        orderRepository.save(new OrderData(visitDay, orders), totalAmount);
    }

    public OrderDto present() {
        return convertToDto();
    }

    private OrderDto convertToDto() {
        int visitDay = orderRepository.findVisitDay();
        Map<String, Integer> orders = orderRepository.findOrderList();
        int totalAmount = orderRepository.findTotalAmount();
        return new OrderDto(visitDay, orders, totalAmount);
    }

    private int getTotalAmount(Map<String, Integer> orders) {
        return orders.entrySet()
                .stream()
                .mapToInt(this::calculateAmount)
                .sum();
    }

    private int calculateAmount(Entry<String, Integer> orders) {
        int price = MenuRepository.findMenuByName(orders.getKey()).price();
        return orders.getValue() * price;
    }
}
