package springtest.dao;

import org.springframework.stereotype.Repository;
import springtest.data.Order;

import java.math.BigInteger;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {


    @Override
    public List<Order> allOrders() {
        return null;
    }

    @Override
    public List<Order> allOrdersByUser(BigInteger userId) {
        return null;
    }

    @Override
    public List<Order> allOrdersByTour(BigInteger tourId) {
        return null;
    }

    @Override
    public List<Order> allConfirmedOrders(boolean confirmed) {
        return null;
    }

    @Override
    public void add(Order order) {

    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public void edit(Order order) {

    }

    @Override
    public Order getById(BigInteger id) {
        return null;
    }
}
