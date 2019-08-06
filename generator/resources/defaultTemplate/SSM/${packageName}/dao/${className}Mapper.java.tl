package ${data.packageName}.dao;

import java.util.List;
import java.util.Map;

import ${data.packageName}.dto.${data.className}DTO;

/**
 * 类描述:     ${data.describe}数据处理接口
 * 创建人:     ${data.author}
 * 创建时间:   ${date(),"yyyy-MM-dd HH:mm:ss"}
 * 版本:       v1.0
 */
public interface ${data.className}Mapper {

	/**
	 * 根据ID查询${data.describe}
	 */
	${data.className}DTO get${data.className}ById(int id);

	/**
	 * 根据条件查询${data.describe}列表
	 */
	List<${data.className}DTO> get${data.className}List(Map<Object,Object> condition);

	/**
	 * 查询${data.describe}的列表总数
	 */
	int get${data.className}ListCount(Map<Object,Object> condition);

	/**
	 * 新增${data.describe}
	 */
	int add${data.className}(${data.className}DTO ${data.lowerClassName}DTO);

	/**
     * 批量新增${data.describe}
     */
    int add${data.className}Batch(List<${data.className}DTO> list);

	/**
	 * 更新${data.describe}
	 */
	int update${data.className}(${data.className}DTO ${data.lowerClassName}DTO);

    /**
    * 批量更新${data.describe}
    */
    int update${data.className}Batch(\@Param("ids") Integer[] ids, \@Param("${data.lowerClassName}") ${data.className}DTO ${data.lowerClassName});

	/**
	 * 删除${data.describe}
	 */
	int delete${data.className}ById(int id);

	/**
     * 批量删除${data.describe}
     */
    int delete${data.className}Batch(Integer[] ids);

	@if(data.tableInfo.logicDel){
    /**
     * 逻辑删除${data.describe}
     */
     int logicDelete${data.className}ById(int id);
    @}

}
