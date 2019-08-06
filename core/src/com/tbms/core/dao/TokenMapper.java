package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.TokenDTO;
import org.apache.ibatis.annotations.Param;

/**
 * 类描述:     数据处理接口
 * 创建人:     青枫
 * 创建时间:   2019-06-02 13:53:22
 * 版本:       v1.0
 */
public interface TokenMapper {

	/**
	 * 根据ID查询
	 */
	TokenDTO getTokenById(int id);

	/**
	 * 根据student_id查询
	 */
	TokenDTO getTokenByStudentId(int student_id);

	/**
	 * 根据条件查询列表
	 */
	List<TokenDTO> getTokenList(Map<Object, Object> condition);

	/**
	 * 查询的列表总数
	 */
	int getTokenListCount(Map<Object, Object> condition);

	/**
	 * 新增
	 */
	int addToken(TokenDTO tokenDTO);

	/**
     * 批量新增
     */
    int addTokenBatch(List<TokenDTO> list);

	/**
	 * 更新
	 */
	int updateToken(TokenDTO tokenDTO);

    /**
    * 批量更新
    */
    int updateTokenBatch(@Param("ids") Integer[] ids, @Param("token") TokenDTO token);

	/**
	 * 删除
	 */
	int deleteTokenById(int id);

	/**
     * 批量删除
     */
    int deleteTokenBatch(Integer[] ids);


}
