package christmas.order.service;

import christmas.menu.model.MenuData;
import christmas.menu.repository.MenuRepository;
import christmas.order.dto.OrderDto;
import christmas.order.model.OrderData;
import christmas.order.repository.OrderRepository;
import java.util.Map;

public class OrderService {
    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;

    public OrderService(OrderRepository orderRepository, MenuRepository menuRepository) {
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
    }

    public void save(int visitDay, Map<String, Integer> orders) {
        orderRepository.save(new OrderData(visitDay, orders));
    }

    public OrderDto present() {
        return convertToDto();
    }

    private OrderDto convertToDto() {
        int visitDay = orderRepository.findOrder().visitDay();
        Map<String, Integer> orders = orderRepository.findOrder().orders();
        int totalAmount = calculateTotalAmount(orderRepository.findOrder().orders());
        return new OrderDto(visitDay, orders, totalAmount);
    }

    private int calculateTotalAmount(Map<String, Integer> orders) {
        int total = 0;
        for (String menuName : orders.keySet()) {
            MenuData menuData = menuRepository.findMenuByName(menuName);
            total += menuData.price() * orders.get(menuName);
        }
        return total;
    }
}
