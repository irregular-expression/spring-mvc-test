package springtest.service;

import springtest.data.Order;

import java.math.BigInteger;
import java.util.List;

public interface OrderApi {
    List<Order> getAllOrders();
    void addOrder(Order order);
    void deleteOrder(Order order);
    void editOrder(Order order);
    Order getOrderById(BigInteger id);

}
