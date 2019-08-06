package com.tbms.core.service.impl;

import java.util.*;
import javax.annotation.Resource;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.service.ResourceService;
import org.springframework.stereotype.Service;
import com.tbms.core.dao.RoleResourceMapper;
import com.tbms.core.dto.RoleResourceDTO;
import com.tbms.core.service.RoleResourceService;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     角色资源业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2018-06-11 22:40:38
 * 版本:       v1.0
 */
@Service("roleResourceService")
public class RoleResourceServiceImpl implements RoleResourceService {

	@Resource
	private RoleResourceMapper roleResourceDAO;

	@Resource
	private ResourceService resourceService;

	/**
	 * 根据ID获取
	 */
	public RoleResourceDTO getRoleResourceById(int id) {
		return roleResourceDAO.getRoleResourceById(id);
	}

	/**
	 * 根据条件获取列表
	 */
	public List<RoleResourceDTO> getRoleResourceList(Map condition) {
		return roleResourceDAO.getRoleResourceList(condition);
	}

	/**
    * 根据条件获取分页列表
    */
    public PageResultSet<RoleResourceDTO> findByPage(Page page) {
		Map<Object, Object> condition = PageCondition.util(page);
        int count = roleResourceDAO.getRoleResourceListCount(null);
        PageResultSet<RoleResourceDTO> resultSet = new PageResultSet<>();
        List<RoleResourceDTO> roleResourcePages = roleResourceDAO.getRoleResourcePage(condition);

        resultSet.setRows(roleResourcePages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取的列表总数
	 */
	public int getRoleResourceListCount(Map condition) {
		return roleResourceDAO.getRoleResourceListCount(condition);
	}

	/**
	 * 新增
	 */
	public int addRoleResource(RoleResourceDTO roleResourceDTO) {
		roleResourceDAO.addRoleResource(roleResourceDTO);
		return roleResourceDTO.getId();
	}

	/**
	 * 更新
	 */
	public int updateRoleResource(RoleResourceDTO roleResourceDTO) throws Exception {
		return roleResourceDAO.updateRoleResource(roleResourceDTO);
	}

	/**
	 * 删除
	 */
	public int deleteRoleResourceById(int id) {
		return roleResourceDAO.deleteRoleResourceById(id);
	}

	@Override
	public List<Integer> getResourceIdList(int id) {
		Map<Object, Object> condition = new HashMap<>();
		condition.put("roleId", id);
		List<RoleResourceDTO> roleResourceList = getRoleResourceList(condition);
		List<Integer> idList;
		if (!roleResourceList.isEmpty()){
			idList = new ArrayList<>();
			roleResourceList.forEach(rr->{
				int resourceId = rr.getResourceId();
				if (resourceId != 0){
					idList.add(resourceId);
				}
			});
			return idList;
		}
		return null;
	}

	public List<String> getResourceNames(int id) {
		Map<Object, Object> condition = new HashMap<>();
		condition.put("roleId", id);
		List<RoleResourceDTO> roleResourceList = getRoleResourceList(condition);
		List<String> resourceNames;
		if (!roleResourceList.isEmpty()){
			resourceNames = new ArrayList<>();
			roleResourceList.forEach(rr->{
				int resourceId = rr.getResourceId();
				if (resourceId != 0){
					String resourceName = resourceService.getResourceById(resourceId).getName();
					if (!resourceName.equals("")){
						resourceNames.add(resourceName);
					}
				}
			});
			return resourceNames;
		}
		return null;
	}

	/**
	 *再根据资源id的集合查找资源权限Permissions
	 * @param resourceIds
	 * @return
	 */
	public Set<String> findPermissions(Set<Integer> resourceIds){
		return resourceService.findPermissions(resourceIds);
	}


}
