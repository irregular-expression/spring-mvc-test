import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springtest.config.PersistenceConfig;
import springtest.dao.UserDao;
import springtest.data.User;

import java.math.BigInteger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class DatabaseTest {

    @Autowired UserDao userDao;

    @Test
    public void isDB_available() throws SQLException {
         String url = "jdbc:mysql://localhost:3306/test?serverTimezone=W-SU";
         String username = "root";
         String password = "2121";
         assertNotNull(DriverManager.getConnection(url, username, password));
    }

    @Test
    public void isUserDaoCreatedCorrectly_onDefaultUser() {
        User user = userDao.getById(BigInteger.ONE);
        assertNotNull(user);
        assertEquals(user.getId(), BigInteger.ONE);
        assertEquals(user.getFirstName(), "Vasya");
        assertEquals(user.getLastName(), "Pupkin");

        List<User> users = userDao.getAllUsers();
        assertTrue(users.size() > 0);
    }

}
