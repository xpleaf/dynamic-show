package cn.xpleaf.springmvc.service;

import java.util.List;
import java.util.Map;

/**
 * 获取网站信息service接口
 */
public interface InfoService {
    /**
     * 获取pv
     */
    public List<Map<String, String>> getPV(String dateStr);

    /**
     * 获取uv
     */
    List<Map<String,String>> getUV(String dateStr);
}
