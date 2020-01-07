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

    private Map<String, User> users = new HashMap<>();

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
    public Optional<User> findByToken(String token) {
        return Optional.of(users.get(token));
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
        return null;
    }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public boolean createOrder(BigInteger tourId, BigInteger userId) {
        return false;
    }

    @Override
    public List<Tour> getToursWithOrders() {
        return null;
    }

    @Override
    public boolean cancelOrder(Order order) {
        return false;
    }


}