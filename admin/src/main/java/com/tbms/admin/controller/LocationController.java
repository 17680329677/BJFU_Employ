package com.tbms.admin.controller;

import com.tbms.core.dto.AreaDTO;
import com.tbms.core.dto.CityDTO;
import com.tbms.core.service.AreaService;
import com.tbms.core.service.CityService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hezhe.du
 * @version 1.0
 * @date 2019/7/12 20:57
 * 支撑省市县联动接口
 */

@RestController
@RequestMapping("/location")
public class LocationController {

    @Resource
    CityService cityService;

    @Resource
    AreaService areaService;

    @GetMapping("/findCityByProvince")
    public String findCityByProvince(@RequestParam("province_code")String province_code) {
        JSONObject result = new JSONObject();
        if (null == province_code || "".equals(province_code)) {
            result.put("code", -1);
            result.put("msg", "参数错误");
            return result.toString();
        }
        Map<String, Object> condition = new HashMap();
        condition.put("provincecode",province_code);
        List<CityDTO> cityList = cityService.getCityList(condition);
        if (cityList.size() == 0) {
            result.put("code", -1);
            result.put("msg", "未找到相关城市");
            return result.toString();
        }
        result.put("code", 200);
        result.put("cityList", cityList);
        return result.toString();
    }

    @GetMapping("/findAreaByCity")
    public String findAreaByCity(@RequestParam("city_code")String city_code) {
        JSONObject result = new JSONObject();
        if (null == city_code || "".equals(city_code)) {
            result.put("code", -1);
            result.put("msg", "参数错误");
            return result.toString();
        }
        Map<String, Object> condition = new HashMap();
        condition.put("citycode",city_code);
        List<AreaDTO> areaList = areaService.getAreaList(condition);
        if (areaList.size() == 0) {
            result.put("code", -1);
            result.put("msg", "未找到相关地区");
            return result.toString();
        }
        result.put("code", 200);
        result.put("areaList", areaList);
        return result.toString();
    }

    @GetMapping("/getCurrentAreaList")
    public String getCurrentAreaList(@RequestParam("code")String code) {
        JSONObject result = new JSONObject();
        Map<String, String> condition = new HashMap<>();
        condition.put("code", code);
        List<AreaDTO> area = areaService.getAreaList(condition);
        if (area == null || area.size() == 0) {
            result.put("code", -1);
            result.put("msg", "获取地区数据失败！");
            return result.toString();
        }
        condition.clear();
        condition.put("citycode", area.get(0).getCitycode());
        List<AreaDTO> areaList = areaService.getAreaList(condition);
        if (areaList == null || areaList.size() == 0) {
            result.put("code", -1);
            result.put("msg", "获取地区数据失败！");
            return result.toString();
        }
        result.put("code", 200);
        result.put("areaList", areaList);
        return result.toString();
    }

    @GetMapping("/getCurrentCityList")
    public String getCurrentCityList(@RequestParam("code")String code) {
        JSONObject result = new JSONObject();
        Map<String, String> condition = new HashMap<>();
        StringBuilder provinceCode = new StringBuilder(code);
        String cityCode = provinceCode.replace(4, 6, "00").toString();
        provinceCode.replace(2, 6, "0000");
        condition.put("provincecode", provinceCode.toString());
        List<CityDTO> cityList = cityService.getCityList(condition);
        if (cityList == null || cityList.size() == 0) {
            result.put("code", -1);
            result.put("msg", "获取地区数据失败！");
            return result.toString();
        }
        result.put("code", 200);
        result.put("cityList", cityList);
        result.put("cityCode", cityCode);
        result.put("provinceCode", provinceCode);
        return result.toString();
    }
}
