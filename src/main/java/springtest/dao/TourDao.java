package springtest.dao;

import org.apache.ibatis.annotations.*;
import springtest.data.Tour;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface TourDao {
    @Select("SELECT * FROM tours")
    @Results({
            @Result(id=true, property="id", column="id"),
            @Result(property="name", column="name"),
            @Result(property="description", column="description"),
            @Result(property="location", column="location"),
            @Result(property="startDate", column="startDate"),
            @Result(property="endDate", column="endDate"),
            @Result(property="countLimit", column="countLimit"),
    })
    List<Tour> getAllTours();

    @Insert("INSERT INTO tours(name, description, location, startDate, endDate, countLimit) VALUES(#{name}, #{description}, #{location}, #{startDate}, #{endDate}, #{countLimit})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void add(Tour tour);

    @Delete("DELETE FROM tours WHERE id=#{id}")
    void delete(Tour tour);

    @Update("UPDATE tours SET name=#{name}, description=#{description}, location=#{location}, startDate=#{startDate}, endDate=#{endDate}, countLimit=#{countLimit} WHERE id=#{id}")
    void edit(Tour tour);

    @Select("SELECT * FROM tours WHERE id = #{id}")
    Tour getById(@Param("id") BigInteger id);

}
