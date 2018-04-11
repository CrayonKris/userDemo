package cn.com.bonc.controller;

import cn.com.bonc.entity.User;
import cn.com.bonc.service.UserService;
import cn.com.bonc.util.JsonResultNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * */
    @RequestMapping("/findAllUser")
    public JsonResultNew<List<User>> findAll(){
        return userService.findAll();
    }
    /**
     * 根据ID查询用户
     * */
    @RequestMapping(value = "/findOne/{id}",method = RequestMethod.GET)
    public JsonResultNew<Object> findOne(@PathVariable("id") String id){
        JsonResultNew<Object> js = userService.findOne(id);
        return js;
    }
    /**
     * 增加用户
     * */
    @RequestMapping(value = "/insertUser/{user}", method = RequestMethod.POST)
    public JsonResultNew<Object> insertUser(@PathVariable("user") User user){
        return userService.insertUser(user);
    }
    /**
     * 删除用户
     * */
    @RequestMapping(value = "/deleteUsers/{id}", method = RequestMethod.GET)
    public JsonResultNew<Object> deleteUsers(@PathVariable("id") String userId){
        //userId = request.getParameter("userId");
        return userService.deleteUserByIds(userId);
    }
    /**
     * 修改用户信息
     * */
    @RequestMapping("/updateUser")
    public JsonResultNew<Object> updateUser(HttpServletRequest request,User u){
        return userService.updateUser(u);
    }
}
