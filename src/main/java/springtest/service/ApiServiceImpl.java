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
import java.util.*;

@Service
public class ApiServiceImpl implements ApiService {

    private Map<String, User> users = new HashMap<>(); //TODO: change to in-memory cache database service

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
    public Optional<String> login(String login, String password) {
         User user = userDao.getByEmailAndPassword(login, password);
         Optional<String> token = Optional.empty();
         if (user != null) {
             token = Optional.of(UUID.randomUUID().toString());
             user.setActive(true);
             userDao.edit(user);
             users.put(token.get(), user);
         }
         return token;
    }

    @Override
    public User findByToken(String token) {
        return users.get(token);
    }

    @Override
    public void register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userDao.add(user);
    }

    @Override
    public void logout(User user) {
        for (Map.Entry<String, User> userData : users.entrySet()) {
            if (userData.getValue().equals(user)) users.remove(userData.getKey());
        }
        user.setActive(false);
        userDao.edit(user);
    }

    @Override
    public List<Tour> getTours() {
        return tourDao.getAllTours();
    }

    @Override
    public List<Order> getOrders(BigInteger userId) {
        return orderDao.getAllOrdersForUser(userId);
    }

    @Override
    public User getUser(BigInteger userId) {
        return userDao.getById(userId);
    }

    @Override
    public void editUser(User user) {
        userDao.edit(user);
    }

    @Override
    public boolean createOrder(BigInteger tourId, BigInteger userId) {
        Tour tour = tourDao.getById(tourId);
        User user = userDao.getById(userId);
        if (tour != null && user != null && tour.getCountLimit() > 0) {
            tour.setCountLimit(tour.getCountLimit() - 1);
            tourDao.edit(tour);
            orderDao.add(new Order(userId, tourId));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Tour> getToursWithOrders(BigInteger userId) {
        return tourDao.getAllOrderedToursForUser(userId);
    }

    @Override
    public boolean cancelOrder(Order order) {
        Tour tour = tourDao.getById(order.getTourId());
        if (!tour.isStarted()) {
            orderDao.delete(order);
            tour.setCountLimit(tour.getCountLimit() + 1);
            tourDao.edit(tour);
            return true;
        } else {
            return false;
        }
    }


}