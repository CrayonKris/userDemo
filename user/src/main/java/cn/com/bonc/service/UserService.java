package cn.com.bonc.service;

import cn.com.bonc.entity.User;
import cn.com.bonc.util.JsonResultNew;

import java.util.List;


public interface UserService {
    JsonResultNew<List<User>> findAll();
    JsonResultNew<Object> findOne(String uid);

    JsonResultNew<Object> insertUser(User user);

    JsonResultNew<Object> deleteUserByIds(String uids);

    JsonResultNew<Object> updateUser(User u);
}
