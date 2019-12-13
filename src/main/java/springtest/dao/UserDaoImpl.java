package springtest.dao;

import org.springframework.stereotype.Repository;
import springtest.data.User;

import java.math.BigInteger;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
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
    public User getById(BigInteger id) {
        return null;
    }
}
