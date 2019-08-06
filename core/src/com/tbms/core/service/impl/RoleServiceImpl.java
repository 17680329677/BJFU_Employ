package com.tbms.core.service.impl;

import java.util.*;
import javax.annotation.Resource;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.dto.RoleResourceDTO;
import com.tbms.core.service.RoleResourceService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.tbms.core.dao.RoleMapper;
import com.tbms.core.dto.RoleDTO;
import com.tbms.core.service.RoleService;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     角色业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2018-06-11 22:40:38
 * 版本:       v1.0
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleDAO;

	@Resource
	private RoleResourceService roleResourceService;

	/**
	 * 根据ID获取
	 */
	public RoleDTO getRoleById(int id) {
		return roleDAO.getRoleById(id);
	}

	/**
	 * 根据条件获取列表
	 */
	public List<RoleDTO> getRoleList(Map condition) {
		return roleDAO.getRoleList(condition);
	}

	/**
    * 根据条件获取分页列表
    */
	public PageResultSet<RoleDTO> findByPage(Page page) {
		Map<Object, Object> condition = PageCondition.util(page);
		int count = roleDAO.getRoleListCount(condition);
		PageResultSet<RoleDTO> resultSet = new PageResultSet<>();
		List<RoleDTO> rolePages = roleDAO.getRolePage(condition);
		rolePages.forEach(role->{
			List<Integer> resourceIdList = roleResourceService.getResourceIdList(role.getId());
			if (null != resourceIdList && !resourceIdList.isEmpty()){
				role.setResourceIdList(resourceIdList);
			}
			String resourceNames = getResourceNames(roleResourceService.getResourceNames(role.getId()));
			if (!StringUtils.isEmpty(resourceNames)){
				role.setResourceNames(resourceNames);
			}
		});
		resultSet.setRows(rolePages);
		resultSet.setTotal(count);
		return resultSet;
	}

	/**
	 * 获取资源名称
	 * @param names
	 * @return
	 */
	private String getResourceNames(List<String> names){
		if (null == names && CollectionUtils.isEmpty(names)){
			return "";
		}
		StringBuilder sbr = new StringBuilder();
		for (String name : names){
			if (!StringUtils.isEmpty(name)){
				sbr.append(name);
				sbr.append(",");
			}
		}
		if (sbr.length() > 0){
			sbr.deleteCharAt(sbr.length() - 1);
		}
		return sbr.toString();
	}

	/**
	 * 获取的列表总数
	 */
	public int getRoleListCount(Map condition) {
		return roleDAO.getRoleListCount(condition);
	}

	/**
	 * 新增
	 */
	public int addRole(RoleDTO roleDTO) {
		roleDAO.addRole(roleDTO);
		int role_id = roleDTO.getId();
		addRoleResource(roleDTO,role_id);
		return role_id;
	}

	/**
	 * 更新
	 */
	public int updateRole(RoleDTO roleDTO) throws Exception {
		//先更新roleDTO
		roleDTO.setStatus(1);
		roleDAO.updateRole(roleDTO);
		int role_id = roleDTO.getId();
		Map map = new HashMap();
		map.put("roleId",role_id);
		//查找RoleResource删除与roleId相关数据
		List<RoleResourceDTO> lists = roleResourceService.getRoleResourceList(map);
		for(RoleResourceDTO list:lists){
			roleResourceService.deleteRoleResourceById(list.getId());
		}
		addRoleResource(roleDTO,role_id);
		return role_id;
	}

	public void addRoleResource(RoleDTO roleDTO,int role_id){
		//重新添加roleResource
		String resourceIds = roleDTO.getResourceIds();
		String[] resIds = resourceIds.split(",");
		for (int i = 0; i < resIds.length; i++) {
			RoleResourceDTO roleResourceDTO = new RoleResourceDTO();
			roleResourceDTO.setRoleId(role_id);
			roleResourceDTO.setResourceId(Integer.parseInt(resIds[i]));
			roleResourceService.addRoleResource(roleResourceDTO);
		}
	}

	/**
	 * 删除
	 */
	public int deleteRoleById(int id) {
		return roleDAO.deleteRoleById(id);
	}

	/**
	 * 找到用户的角色，返回用户的角色集合，本软件中一个用户只有一种角色
	 */
	public Set<String> findRoles(Integer roleId){
		Set<String> roleSet = new HashSet<>();
		RoleDTO role = getRoleById(roleId);
		if(role!=null){
			roleSet.add(role.getRole());
		}
		return roleSet;
	}

	/**
	 * 根据角色id，先在角色资源表中获取资源id 构成集合，
	 * @param roleId
	 * @return
	 */

	@Override
	public Set<String> findPermissions(Integer roleId) {
		Set<Integer> resourceIds = new HashSet<>();
		Map<Object, Object> condition = new HashMap<>();
		condition.put("roleId", roleId);
		List<RoleResourceDTO> list = roleResourceService.getRoleResourceList(condition);
		for(RoleResourceDTO roleResource:list){
			resourceIds.add(roleResource.getResourceId());
		}
		return roleResourceService.findPermissions(resourceIds);
	}


}
