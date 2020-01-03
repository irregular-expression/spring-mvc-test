package springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtest.dao.OrderDao;
import springtest.dao.TourDao;
import springtest.dao.UserDao;
import springtest.data.User;

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


}