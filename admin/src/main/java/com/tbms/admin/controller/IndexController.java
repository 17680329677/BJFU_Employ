package com.tbms.admin.controller;

import com.tbms.core.common.base.Constants;
import com.tbms.core.dto.ResourceDTO;
import com.tbms.core.dto.UserDTO;
import com.tbms.core.service.ResourceService;
import com.tbms.core.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class IndexController {

    @Autowired
    public UserService userService;

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/")
    public String toMain(Model model){
        StringBuilder dom = new StringBuilder();
        initDomTree(dom, model);
        model.addAttribute(Constants.MENU_TREE, dom);
        return "main";
    }

    private void initDomTree(StringBuilder dom, Model model){
        UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();
        dom.append("<ul class=\"sidebar-menu\" data-widget=\"tree\">");
        dom.append("<li class=\"header\">系统控制台</li>");
        List<ResourceDTO> menu = resourceService.findMenus(userService.findPermissions(user.getUsername()));//getResourceList(condition);
        getMenuTree(menu, Constants.MENU_ROOT_ID, dom);
        dom.append("</ul>");
    }

    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    private List<ResourceDTO> getMenuTree(List<ResourceDTO> source, int pid, StringBuilder dom) {
        List<ResourceDTO> target = getChildResourceByPid(source, pid);
        for (ResourceDTO res:target){
            dom.append("<li class='treeview'>");
            dom.append("<a href='" + res.getUrl() + "'>");
            dom.append("<i class= '" + res.getIcon() + "'></i>");
            dom.append("<span>" + res.getName() + "</span>");
            if (Constants.SHARP.equals(res.getUrl())) {
                dom.append("<span class='pull-right-container'><i class='fa fa-angle-left pull-right'></i> </span>");
            }
            dom.append("</a>");
            dom.append("<ul class='treeview-menu'>");
            res.setChildren(getMenuTree(source, res.getId(), dom));
            dom.append("</ul>");
            dom.append("</li>");
        }
        return target;
    }

    private List<ResourceDTO> getChildResourceByPid(List<ResourceDTO> source, int pId) {
        List<ResourceDTO> child = new ArrayList<>();
        for(ResourceDTO res:source) {
            if (Objects.equals(pId, res.getParentId())) {
                child.add(res);
            }
        }
        return child;
    }
}
