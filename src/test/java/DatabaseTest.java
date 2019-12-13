import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

@RunWith(BlockJUnit4ClassRunner.class)
public class DatabaseTest {

     @Test
    public void isDB_available() throws SQLException {
         String url = "jdbc:mysql://localhost:3306/test?serverTimezone=W-SU";
         String username = "root";
         String password = "2121";
         assertNotNull(DriverManager.getConnection(url, username, password));
     }

}
