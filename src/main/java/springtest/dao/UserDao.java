package springtest.dao;

import org.apache.ibatis.annotations.*;
import springtest.data.User;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM users")
    @Results({
            @Result(id=true, property="id", column="id"),
            @Result(property="firstName", column="firstName"),
            @Result(property="lastName", column="lastName"),
            @Result(property="email", column="email"),
            @Result(property="password", column="password"),
            @Result(property="active", column="active"),
            @Result(property="birthday", column="birthday"),
    })
    List<User> getAllUsers();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getById(@Param("id") BigInteger id);

    @Select("SELECT * FROM users WHERE email = #{email} AND password = #{password}")
    User getByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Insert("INSERT INTO users(firstName, lastName, email, password, active, birthday) VALUES(#{firstName}, #{lastName}, #{email}, #{password}, #{active}, #{birthday})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void add(User user);

    @Delete("DELETE FROM users WHERE id=#{id}")
    void delete(User user);

    @Update("UPDATE users SET firstName=#{firstName}, lastName=#{lastName}, email=#{email}, password=#{password}, active=#{active}, birthday=#{birthday} WHERE id=#{id}")
    void edit(User user);

}
