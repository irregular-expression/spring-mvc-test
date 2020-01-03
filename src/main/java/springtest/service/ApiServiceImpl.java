package springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtest.dao.OrderDao;
import springtest.dao.TourDao;
import springtest.dao.UserDao;
import springtest.data.Order;
import springtest.data.Tour;
import springtest.data.User;

import java.math.BigInteger;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private OrderDao orderDao;
    private UserDao userDao;
    private TourDao tourDao;

    @Autowired public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    @Autowired public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired public void setTourDao(TourDao tourDao) {
        this.tourDao = tourDao;
    }


    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public void addOrder(Order order) {
        orderDao.add(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderDao.delete(order);
    }

    @Override
    public void editOrder(Order order) {
        orderDao.edit(order);
    }

    @Override
    public Order getOrderById(BigInteger id) {
        return orderDao.getById(id);
    }

    @Override
    public List<Tour> getAllTours() {
        return tourDao.getAllTours();
    }

    @Override
    public void addTour(Tour tour) {
        tourDao.add(tour);
    }

    @Override
    public void deleteTour(Tour tour) {
        tourDao.delete(tour);
    }

    @Override
    public void editTour(Tour tour) {
        tourDao.edit(tour);
    }

    @Override
    public Tour getTourById(BigInteger id) {
        return tourDao.getById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Override
    public void editUser(User user) {
       userDao.edit(user);
    }

    @Override
    public User getUserById(BigInteger id) {
        return userDao.getById(id);
    }
}