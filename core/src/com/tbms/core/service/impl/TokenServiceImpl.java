package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbms.core.dao.TokenMapper;
import com.tbms.core.dto.TokenDTO;
import com.tbms.core.service.TokenService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2019-06-02 13:53:22
 * 版本:       v1.0
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {


	@Resource
	private TokenMapper tokenDAO;

	/**
	 * 根据ID获取
	 */
	public TokenDTO getTokenById(int id) {
		return tokenDAO.getTokenById(id);
	}

	/**
	 * 根据student_id获取
	 */
	public TokenDTO getTokenByStudentId(int student_id) {
		return tokenDAO.getTokenByStudentId(student_id);
	}

	/**
	 * 根据条件获取列表
	 */
	public List<TokenDTO> getTokenList(Map condition) {
		return tokenDAO.getTokenList(condition);
	}

	/**
    * 根据条件获取分页列表
    */
    public PageResultSet<TokenDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = tokenDAO.getTokenListCount(condition);
        PageResultSet<TokenDTO> resultSet = new PageResultSet<>();
        List<TokenDTO> tokenPages = tokenDAO.getTokenList(condition);
        resultSet.setRows(tokenPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取的列表总数
	 */
	public int getTokenListCount(Map condition) {
		return tokenDAO.getTokenListCount(condition);
	}

	/**
	 * 新增
	 */
	public int addToken(TokenDTO tokenDTO) {
		tokenDAO.addToken(tokenDTO);
		return tokenDTO.getId();
	}

	/**
     * 批量新增
     */
    @Transactional
    public int addTokenBatch(List<TokenDTO> list) throws Exception{
        return 0;
    }

	/**
	 * 更新
	 */
	public int updateToken(TokenDTO tokenDTO) throws Exception {
		return tokenDAO.updateToken(tokenDTO);
	}

    /**
     * 批量更新
     */
	@Override
	@Transactional
	public int updateTokenBatch(Integer[] ids,TokenDTO tokenDTO) throws Exception{
		return tokenDAO.updateTokenBatch(ids,tokenDTO);
	}

	/**
	 * 删除
	 */
	public int deleteTokenById(int id) {
		return tokenDAO.deleteTokenById(id);
	}

	/**
	 *批量删除
	 */
	@Transactional
	public int deleteTokenBatch(Integer[] ids)throws Exception{
		return tokenDAO.deleteTokenBatch(ids);
	}


}
