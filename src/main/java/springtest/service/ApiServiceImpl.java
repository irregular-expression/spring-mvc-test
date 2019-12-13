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
import java.util.Date;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private OrderDao orderDao;
    private UserDao userDao;
    private TourDao tourDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setTourDao(TourDao tourDao) {
        this.tourDao = tourDao;
    }

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
    public List<Tour> allTours() {
        return null;
    }

    @Override
    public List<Tour> allToursByName(String name) {
        return null;
    }

    @Override
    public List<Tour> allToursByLocation(String location) {
        return null;
    }

    @Override
    public List<Tour> allToursByDescription(String description) {
        return null;
    }

    @Override
    public List<Tour> allToursInTimePeriod(Date start, Date end) {
        return null;
    }

    @Override
    public void add(Tour tour) {

    }

    @Override
    public void delete(Tour tour) {

    }

    @Override
    public void edit(Tour tour) {

    }

    @Override
    public Tour getTourById(BigInteger id) {
        return null;
    }

    @Override
    public List<User> allUsers() {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public User getUserById(BigInteger id) {
        return null;
    }

    @Override
    public Order getOrderById(BigInteger id) {
        return null;
    }
}
