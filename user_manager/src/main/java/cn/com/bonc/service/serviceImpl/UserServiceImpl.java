package cn.com.bonc.service.serviceImpl;

import cn.com.bonc.dao.UserMapper;
import cn.com.bonc.entity.User;
import cn.com.bonc.service.UserService;
import cn.com.bonc.util.JsonResultNew;
import cn.com.bonc.util.MyBusinessEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现用户的增删改查
 * */
@Service
public class UserServiceImpl implements UserService {

    public static final String SUCCESS_DEL = "删除用户成功";
    public static final String FAILED_DEL = "删除用户失败";
    @Autowired
    private UserMapper userMapper;

    /*查询所有用户*/
    @Override
    public JsonResultNew<List<User>> findAll() {
        List<User> users = userMapper.findAll();
        if (users==null){
            return new JsonResultNew<List<User>>("没有找到用户");
        }else{
            return new JsonResultNew<List<User>>(users);
        }
    }
    /*查询某一用户*/
    @Override
    public JsonResultNew<Object> findOne(String uId) {
        User user = userMapper.findOne(uId);
        return new JsonResultNew<Object>(user);
    }

    /*插入用户*/
    @Override
    public JsonResultNew<Object> insertUser(User user) {
        Integer i = userMapper.insertUser(user);
        if (i>0) {
            return new JsonResultNew<Object>(MyBusinessEnum.BUSINESS_SUCCESS, "新增用户成功");
        }else{
            return new JsonResultNew<Object>(MyBusinessEnum.BUSINESS_ERROR,"新增用户失败");
        }
    }

    /*删除某一用户*/
    @Override
    public JsonResultNew<Object> deleteUserByIds(String userId) {
        Integer i = userMapper.deleteUserByIds(userId);
        if (i>0){
            return new JsonResultNew<Object>(MyBusinessEnum.BUSINESS_ERROR,SUCCESS_DEL);
        }else{
            return new JsonResultNew<Object>(MyBusinessEnum.BUSINESS_ERROR,FAILED_DEL);
        }
    }

    /*更改用户信息*/
    @Override
    public JsonResultNew<Object> updateUser(User u) {
        User user = userMapper.updateUser(u);
        return new JsonResultNew<Object>(user);
    }

}
