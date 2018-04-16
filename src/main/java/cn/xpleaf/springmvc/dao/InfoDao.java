package cn.xpleaf.springmvc.dao;

import java.util.List;
import java.util.Map;

/**
 * 获取网站信息dao接口
 */
public interface InfoDao {

    /**
     * 获取pv
     */
    public List<Map<String, String>> getPV(String dateStr);

    /**
     * 获取uv
     */
    List<Map<String,String>> getUV(String dateStr);
}
