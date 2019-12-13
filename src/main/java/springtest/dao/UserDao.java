package springtest.dao;

import springtest.data.User;

import java.math.BigInteger;
import java.util.List;

public interface UserDao {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(BigInteger id);

}
