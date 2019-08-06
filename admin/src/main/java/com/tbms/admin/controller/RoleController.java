package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import com.tbms.core.dto.ResourceDTO;
import com.tbms.core.dto.RoleDTO;
import com.tbms.core.service.ResourceService;
import com.tbms.core.service.RoleService;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 类描述:     角色控制器
 * 创建人:     青枫
 * 创建时间:   2018-06-10 16:21:26
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @Resource
    private ResourceService resourceService;

    @RequestMapping
    public String toRolePage(){
        return "role";
    }

    /**
	 * 查询列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<RoleDTO> list(Page page) throws Exception {
        return roleService.findByPage(page);
    }

    /**
	 * 根据id查询
	 */
    @ResponseBody
    @RequestMapping("/{id}")
    public RoleDTO getRoleById(@PathVariable("id") Integer id) throws Exception {
        return roleService.getRoleById(id);
    }

    /**
	 * 根据id删除
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deleteRole(@RequestParam("id") Short[] ids) throws Exception {
        Arrays.asList(ids).forEach(id -> roleService.deleteRoleById(id));
        return Result.Success();
    }

    /**
	 * 新增
	 */
	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@Validated RoleDTO role,BindingResult bindingResult) throws Exception{
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             roleService.addRole(role);
         } catch (Throwable throwable){
             return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
	 * 更新
	 */
	@ResponseBody
    @RequestMapping("/update")
    public Result updateRole(@Validated RoleDTO role,BindingResult bindingResult) throws Exception {
         try{
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             roleService.updateRole(role);
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    @ResponseBody
    @RequestMapping("/resourceList")
    public List<ResourceDTO> getResourceList(){
        return resourceService.getResourceList(null);
    }
}
