package springtest.dao;

import springtest.data.Order;

import java.math.BigInteger;
import java.util.List;

public interface OrderDao {
    List<Order> allOrders();
    List<Order> allOrdersByUser(BigInteger userId);
    List<Order> allOrdersByTour(BigInteger tourId);
    List<Order> allConfirmedOrders(boolean confirmed);
    void add(Order order);
    void delete(Order order);
    void edit(Order order);
    Order getById(BigInteger id);

}
