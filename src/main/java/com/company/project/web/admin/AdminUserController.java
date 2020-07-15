package com.company.project.web.admin;

import com.company.project.model.User;
import com.company.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description:
 * @Author: wangsh
 * @Date: 2020/5/21 11:20
 */

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public ModelAndView getUserList(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_list");
        List<User> userList = userService.findAll();
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }
}
