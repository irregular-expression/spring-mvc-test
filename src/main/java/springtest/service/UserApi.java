package springtest.service;

import springtest.data.User;

import java.math.BigInteger;
import java.util.List;

public interface UserApi {
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(User user);
    void editUser(User user);
    User getUserById(BigInteger id);

}
