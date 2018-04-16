package cn.xpleaf.springmvc.utils;

import java.util.*;

/**
 * 省份信息工具类
 * 存放了每个省的拼音名称以及其中文名称的对应关系
 */
public class ProvinceUtil {

    // 省份拼音与中文名称对应map
    public static HashMap<String, String> provinceMap;


    static {
        // 初始化省份map
        provinceMap = new HashMap<>();
        provinceMap.put("beijing", "北京");
        provinceMap.put("tianjin", "天津");
        provinceMap.put("shanghai", "上海");
        provinceMap.put("chongqing", "重庆");
        provinceMap.put("hebei", "河北");
        provinceMap.put("henan", "河南");
        provinceMap.put("yunnan", "云南");
        provinceMap.put("liaoning", "辽宁");
        provinceMap.put("heilongjiang", "黑龙江");
        provinceMap.put("hunan", "湖南");
        provinceMap.put("anhui", "安徽");
        provinceMap.put("shandong", "山东");
        provinceMap.put("xinjiang", "新疆");
        provinceMap.put("jiangsu", "江苏");
        provinceMap.put("zhejiang", "浙江");
        provinceMap.put("jiangxi", "江西");
        provinceMap.put("hubei", "湖北");
        provinceMap.put("guangxi", "广西");
        provinceMap.put("gansu", "甘肃");
        provinceMap.put("shanxi", "山西");
        provinceMap.put("neimenggu", "内蒙古");
        provinceMap.put("shaanxi", "陕西");
        provinceMap.put("jilin", "吉林");
        provinceMap.put("fujian", "福建");
        provinceMap.put("guizhou", "贵州");
        provinceMap.put("guangdong", "广东");
        provinceMap.put("qinghai", "青海");
        provinceMap.put("xizang", "西藏");
        provinceMap.put("sicuan", "四川");
        provinceMap.put("ningxia", "宁夏");
        provinceMap.put("hainan", "海南");
        provinceMap.put("taiwan", "台湾");
        provinceMap.put("xianggang", "香港");
        provinceMap.put("aomen", "澳门");

    }

    /**
     * 找出最大的pv值
     * @return  最大的pv值，字符串类型
     */
    public static List<String> getMinMaxPV(List<Map<String, String>> pvData) {
        Long min = 0L;
        Long max = 0L;
        for(Map<String, String> map : pvData) {
            Long value = Long.valueOf(map.get("value"));
            min = value < min ? value : min;
            max = value > max ? value : max;
        }

        return Arrays.asList(min + "", max + "");
    }

}
