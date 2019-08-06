package com.tbms.admin.controller;

import com.tbms.core.dto.UserDTO;
import com.tbms.core.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
@Controller
@RequestMapping("/self")
public class MyselfController {
    @Resource
    private UserService userService;

    @RequestMapping
    public String toSelf(Model model){
        UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("currentUser",userService.getUserByName(user.getUsername()));
        return "myself";
    }

}
