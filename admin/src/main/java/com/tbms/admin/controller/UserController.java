package com.tbms.admin.controller;

import com.tbms.core.common.annotation.SystemLog;
import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import com.tbms.core.dto.DepartDTO;
import com.tbms.core.dto.RoleDTO;
import com.tbms.core.dto.UserDTO;
import com.tbms.core.service.DepartService;
import com.tbms.core.service.RoleService;
import com.tbms.core.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述:     管理员控制器
 * 创建人:     青枫
 * 创建时间:   2018-06-10 16:21:26
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private DepartService departService;

    @RequestMapping
    public String toUserInfo(Model model){
        UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();
        Map map = new HashMap();
        Map condition = new HashMap();
        //管理员如果不是超级管理员，不能添加超级管理员
        if(!isRootUser(roleService,user)){
            map.put("role","admin");//院系管理员只能添加院系管理员
            condition.put("code",user.getDepartCode());
        }else{
            map = null;
            condition = null;
        }
        //角色列表
        List<RoleDTO> roles = roleService.getRoleList(map);
        if (!roles.isEmpty())
            model.addAttribute("roleList", roles);
        //部门列表
        List<DepartDTO> departList = departService.getDepartList(condition);
        if (!departList.isEmpty())
            model.addAttribute("departList", departList);

        return "user";
    }

    /**
     * 判断用户是否超级管理员
     */
    private boolean isRootUser(RoleService roleService,UserDTO user){
        int roleId = Integer.parseInt(user.getRoleId());
        if("root".equals(roleService.getRoleById(roleId).getRole())){
            return true;
        }else{
            return false;
        }
    }

    /**
	 * 查询列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<UserDTO> list(Page page) throws Exception {
        return userService.findByPage(page);
    }

    /**
	 * 根据id查询
	 */
    @RequestMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Integer id) throws Exception {
        return userService.getUserById(id);
    }

    /**
	 * 根据id删除
	 */
	@ResponseBody
    @RequestMapping("/delete")
    @SystemLog("删除管理员")
    public Result deleteUser(@RequestParam("id") Integer[] ids) throws Exception {
        if (isSelf(ids)) {
            return Result.Failure(ResultCodeEnum.FailedDelOwn);
        }
        Arrays.asList(ids).forEach(id -> userService.deleteUserById(id));
        return Result.Success("成功删除管理员");
    }

    /**
	 * 新增
	 */
	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @SystemLog("添加管理员")
    public Result create(@Validated UserDTO user,BindingResult bindingResult) throws Exception{
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             userService.addUser(user);
         } catch (Throwable throwable){
             return Result.Failure("0", "添加失败,请检查数据");
         }
         return Result.Success("成功添加管理员");
    }

    /**
	 * 更新
	 */
	@ResponseBody
    @RequestMapping("/update")
    @SystemLog("更新管理员")
    public Result updateUser(@Validated UserDTO user,BindingResult bindingResult) throws Exception {
         try{
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             userService.updateUser(user);
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success("成功更新管理员");
    }

    @ResponseBody
    @RequestMapping(value = "/unable")
    @SystemLog("注销管理员")
    public Result unable(@RequestParam("id") Integer[] ids) {
        if (isSelf(ids)) {
            return Result.Failure(ResultCodeEnum.FailedDelOwn);
        }
        Arrays.stream(ids).forEach(id->userService.unableUserById(id));
        return Result.Success("成功注销管理员");
    }

    private boolean isSelf(Integer[] ids){
        Subject subject = SecurityUtils.getSubject();
        UserDTO currentUserDto = (UserDTO) subject.getPrincipal();
        return Arrays.stream(ids).anyMatch(id -> id.equals(currentUserDto.getId()));
    }
}
