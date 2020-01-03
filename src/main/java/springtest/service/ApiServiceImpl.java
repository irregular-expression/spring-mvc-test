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
    public boolean auth(String login, String password) {
         User user = userDao.getByEmailAndPassword(login, password);
         if (user == null) {
             return false;
         } else {
             user.setActive(true);
             userDao.edit(user);
             return true;
         }
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