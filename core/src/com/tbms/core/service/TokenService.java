package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.TokenDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     业务接口
 * 创建人:     青枫
 * 创建时间:   2019-06-02 13:53:22
 * 版本:       v1.0
 */
public interface TokenService {

	/**
	 * 根据ID获取
	 */
	TokenDTO getTokenById(int id);

	/**
	 * 根据student_id获取
	 */
	TokenDTO getTokenByStudentId(int student_id);

	/**
	 * 根据条件获取列表
	 */
	List<TokenDTO> getTokenList(Map condition);

	/**
    * 根据条件分页查询获取列表
    */
    PageResultSet<TokenDTO> findByPage(Page page);

	/**
	 * 获取的列表总数
	 */
	int getTokenListCount(Map condition);

	/**
	 * 新增
	 */
	int addToken(TokenDTO tokenDTO);

	/**
     * 批量添加
     */
    int addTokenBatch(List<TokenDTO> list) throws Exception;

	/**
	 * 更新
	 */
	int updateToken(TokenDTO tokenDTO) throws Exception;

	/**
     * 批量更新
     */
    int updateTokenBatch(Integer[] ids, TokenDTO tokenDTO) throws Exception;

	/**
	 * 删除
	 */
	int deleteTokenById(int id) throws Exception;

	/**
     * 批量删除
     */
    int deleteTokenBatch(Integer[] ids) throws Exception;


}
