package odko.nanjid.onlineshop2.service;

import odko.nanjid.onlineshop2.domain.Order;
import odko.nanjid.onlineshop2.domain.OrderStatus;

public interface OrderService {
    Order findById(Long id);

    void updateOrderStatusById(Long Id, OrderStatus status);

    Order saveOrder(Order order, String sellerId, String coupon);

    String cancelOrder(Long orderId);

}
