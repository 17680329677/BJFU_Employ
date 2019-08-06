package com.tbms.core.service.impl;

import java.util.*;
import javax.annotation.Resource;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tbms.core.dao.ResourceMapper;
import com.tbms.core.dto.ResourceDTO;
import com.tbms.core.service.ResourceService;

/**
 * 类描述:     资源业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2018-06-11 22:40:38
 * 版本:       v1.0
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {


	@Resource
	private ResourceMapper resourceDAO;

	/**
	 * 根据ID获取
	 */
	public ResourceDTO getResourceById(int id) {
		return resourceDAO.getResourceById(id);
	}

	/**
	 * 根据条件获取列表
	 */
	public List<ResourceDTO> getResourceList(Map condition) {
		return resourceDAO.getResourceList(condition);
	}

	/**
	 * 获取的列表总数
	 */
	public int getResourceListCount(Map condition) {
		return resourceDAO.getResourceListCount(condition);
	}

	/**
	 * 新增
	 */
	public int addResource(ResourceDTO resourceDTO) {
		int pid = resourceDTO.getParentId();
		String parentIds = resourceDAO.getResourceById(pid).getParentIds();
		resourceDTO.setParentIds(parentIds+"/"+pid);
		resourceDAO.addResource(resourceDTO);
		return resourceDTO.getId();
	}

	/**
	 * 更新
	 */
	public int updateResource(ResourceDTO resourceDTO) throws Exception {
		int pid = resourceDTO.getParentId();
		String parentIds = resourceDAO.getResourceById(pid).getParentIds();
		resourceDTO.setParentIds(parentIds+"/"+pid);
		return resourceDAO.updateResource(resourceDTO);
	}

	/**
	 * 删除
	 */
	public int deleteResourceById(int id) {
		return resourceDAO.deleteResourceById(id);
	}


	@Override
	public Set<String> findPermissions(Set<Integer> resourceIds) {
		Set<String> permissions = new HashSet<>();
		for (Integer resourceId : resourceIds) {
			ResourceDTO resource = getResourceById(resourceId);
			if (resource != null && !StringUtils.isEmpty(resource.getPermission())) {
				permissions.add(resource.getPermission());
			}
		}
		return permissions;
	}

	@Override
	public List<ResourceDTO> findMenus(Set<String> permissions) {
		Map condition = new HashMap();
		condition.put("type","menu");
		List<ResourceDTO> resourceList = resourceDAO.getResourceList(condition);
		List<ResourceDTO> menus = new ArrayList<>();
		for(ResourceDTO resource:resourceList){
			if(resource.isRootNode()){
				continue;
			}
			if (!hasPermission(permissions, resource)) {
				continue;
			}
			menus.add(resource);
		}
		return menus;
	}

	private boolean hasPermission(Set<String> permissions, ResourceDTO resource) {
		if (StringUtils.isEmpty(resource.getPermission())) {
			return true;
		}
		for (String permission : permissions) {
			WildcardPermission p1 = new WildcardPermission(permission);
			WildcardPermission p2 = new WildcardPermission(resource.getPermission());
			if (p1.implies(p2) || p2.implies(p1)) {
				return true;
			}
		}
		return false;
	}
}
