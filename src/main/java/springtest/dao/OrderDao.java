package springtest.dao;

import org.apache.ibatis.annotations.*;
import springtest.data.Order;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface OrderDao {
    @Select("SELECT * FROM orders")
    @Results({
            @Result(id=true, property="id", column="id"),
            @Result(property="userId", column="userId"),
            @Result(property="tourId", column="tourId"),
            @Result(property="confirmed", column="confirmed"),
            @Result(property="timeKey", column="timeKey"),
    })
    List<Order> getAllOrders();

    @Select("SELECT * FROM orders WHERE userId=#{userId}")
    @Results({
            @Result(id=true, property="id", column="id"),
            @Result(property="userId", column="userId"),
            @Result(property="tourId", column="tourId"),
            @Result(property="confirmed", column="confirmed"),
            @Result(property="timeKey", column="timeKey"),
    })
    List<Order> getAllOrdersForUser(@Param("userId") BigInteger userId);

    @Insert("INSERT INTO orders(userId, tourId, confirmed, timeKey) VALUES(#{userId}, #{tourId}, #{confirmed}, CURRENT_TIMESTAMP)")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void add(Order order);

    @Delete("DELETE FROM orders WHERE id=#{id}")
    void delete(Order order);

    @Update("UPDATE orders SET userId=#{userId}, tourId=#{tourId}, confirmed=#{confirmed}, timeKey=CURRENT_TIMESTAMP WHERE id=#{id}")
    void edit(Order order);

    @Select("SELECT * FROM orders WHERE id = #{id}")
    Order getById(@Param("id") BigInteger id);

}
