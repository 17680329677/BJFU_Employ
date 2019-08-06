package ${data.packageName}.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import ${data.packageName}.dto.${data.className}DTO;
import ${data.packageName}.service.${data.className}Service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import java.util.Map;

/**
 * 类描述:     ${data.describe}控制器
 * 创建人:     ${data.author}
 * 创建时间:   ${date(),"yyyy-MM-dd HH:mm:ss"}
 * 版本:       v1.0
 */
\@Controller
\@RequestMapping("/${data.lowerClassName}")
public class ${data.className}Controller {
    \@Resource
    private ${data.className}Service ${data.lowerClassName}Service;

    /**
     * 显示${data.describe}页面
    */
    \@RequestMapping
    public String to${data.className}(){
            return "${data.lowerClassName}";
    }

    /**
	 * 查询${data.describe}列表
	 */
	\@ResponseBody
    \@RequestMapping("/list")
    public PageResultSet<${data.className}DTO> list(Page page) throws Exception {
        return ${data.lowerClassName}Service.findByPage(page);
    }

    /**
	 * 根据id查询${data.describe}
	 */
    \@RequestMapping("/{id}")
    public ${data.className}DTO get${data.className}ById(\@PathVariable("id") Integer id) throws Exception {
        return ${data.lowerClassName}Service.get${data.className}ById(id);
    }

    /**
	 * 根据id删除${data.describe}
	 */
	\@ResponseBody
    \@RequestMapping("/delete")
    public Result delete${data.className}(\@RequestParam("id") Integer[] ids) throws Exception {
        Arrays.asList(ids).forEach(id -> ${data.lowerClassName}Service.delete${data.className}ById(id));
        return Result.Success();
    }

    /**
	 * 新增${data.describe}
	 */
	\@ResponseBody
    \@RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(\@Validated ${data.className}DTO ${data.lowerClassName},BindingResult bindingResult) throws Exception{
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             ${data.lowerClassName}Service.add${data.ClassName}(${data.lowerClassName});
         } catch (Throwable throwable){
             return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
	 * 更新${data.describe}
	 */
	\@ResponseBody
    \@RequestMapping("/update")
    public Result update${data.className}(\@Validated ${data.className}DTO ${data.lowerClassName},BindingResult bindingResult) throws Exception {
         try{
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             ${data.lowerClassName}Service.update${data.ClassName}(${data.lowerClassName});
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }
}
