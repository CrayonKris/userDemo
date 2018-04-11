package cn.com.bonc.dao;

import cn.com.bonc.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Insert("INSERT INTO user_info (user_name,gender,age,location,password,create_time,true_name,state) " +
            "VALUES (#{userName},#{gender},#{age},#{location},#{password},#{createTime},#{trueName},#{state})")
    Integer insertUser(User user);
    @Delete("UPDATE user_info set state=0 WHERE user_id=#{userId}")
    Integer deleteUserByIds(String userId);

    @Update("UPDATE user_info set user_name=#{userName},gender=#{gender},age=#{age}," +
            "location=#{location},password=#{password}," +
            "reate_time=#{createTime},true_name=#{trueName},state=#{state},")
    User updateUser(User user);

    @Select("select * from user_info")
    @ResultMap("cn.com.bonc.dao.UserMapper.userMap")
    List<User> findAll();

    @Select("select * from user_info where user_id=#{uId}")
    @ResultMap("cn.com.bonc.dao.UserMapper.userMap")
    User findOne(String uId);
}
