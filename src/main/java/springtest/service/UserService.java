package springtest.service;

import springtest.data.User;

import java.math.BigInteger;
import java.util.List;

public interface UserService {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getUserById(BigInteger id);

}
