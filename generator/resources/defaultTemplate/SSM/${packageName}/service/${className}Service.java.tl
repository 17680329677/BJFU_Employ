package ${data.packageName}.service;

import java.util.List;
import java.util.Map;

import ${data.packageName}.dto.${data.className}DTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     ${data.describe}业务接口
 * 创建人:     ${data.author}
 * 创建时间:   ${date(),"yyyy-MM-dd HH:mm:ss"}
 * 版本:       v1.0
 */
public interface ${data.className}Service {

	/**
	 * 根据ID获取${data.describe}
	 */
	${data.className}DTO get${data.className}ById(int id);

	/**
	 * 根据条件获取${data.describe}列表
	 */
	List<${data.className}DTO> get${data.className}List(Map condition);

	/**
    * 根据条件分页查询获取${data.describe}列表
    */
    PageResultSet<${data.className}DTO> findByPage(Page page);

	/**
	 * 获取${data.describe}的列表总数
	 */
	int get${data.className}ListCount(Map condition);

	/**
	 * 新增${data.describe}
	 */
	int add${data.className}(${data.className}DTO ${data.lowerClassName}DTO);

	/**
     * 批量添加${data.describe}
     */
    int add${data.className}Batch(List<${data.className}DTO> list) throws Exception;

	/**
	 * 更新${data.describe}
	 */
	int update${data.className}(${data.className}DTO ${data.lowerClassName}DTO) throws Exception;

	/**
     * 批量更新${data.describe}
     */
    int update${data.className}Batch(Integer[] ids,${data.className}DTO ${data.lowerClassName}DTO) throws Exception;

	/**
	 * 删除${data.describe}
	 */
	int delete${data.className}ById(int id) throws Exception;

	/**
     * 批量删除${data.describe}
     */
    int delete${data.className}Batch(Integer[] ids) throws Exception;

	@if(data.tableInfo.logicDel){
	/**
	 * 逻辑删除${data.describe}
	 */
	 int logicDelete${data.className}ById(int id);
	@}

}
