package cn.xpleaf.springmvc.dao.impl;

import cn.xpleaf.springmvc.dao.InfoDao;
import cn.xpleaf.springmvc.utils.JedisUtil;
import cn.xpleaf.springmvc.utils.ProvinceUtil;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 获取网站信息dao实现类
 */
public class InfoDaoImpl implements InfoDao {

    @Override
    public List<Map<String, String>> getPV(String dateStr) {
        Jedis jedis = JedisUtil.getJedis();
        List<Map<String, String>> pvData = new ArrayList<>();
        String pvKey = null;
        String result = null;
        Map<String, String> map = null;
        for(String province : ProvinceUtil.provinceMap.keySet()) {
            pvKey = province + "_pv";
            result = jedis.hget(pvKey, dateStr);
            if(result == null) {
                result = "0";
            }
            map = new HashMap<>();
            map.put("name", ProvinceUtil.provinceMap.get(province));
            map.put("value", result);
            pvData.add(map);
        }

        // 释放jedis资源
        JedisUtil.returnJedis(jedis);

        return pvData;
    }

    @Override
    public List<Map<String, String>> getUV(String dateStr) {
        Jedis jedis = JedisUtil.getJedis();
        List<Map<String, String>> uvData = new ArrayList<>();
        String uvKey = null;
        Long result = null;
        Map<String, String> map = null;
        for(String province : ProvinceUtil.provinceMap.keySet()) {
            uvKey = province + "_mids_" + dateStr;
            result = jedis.scard(uvKey);
            if(result == null) {
                result = 0L;
            }
            map = new HashMap<>();
            map.put("name", ProvinceUtil.provinceMap.get(province));
            map.put("value", result + "");
            uvData.add(map);
        }

        // 释放jedis资源
        JedisUtil.returnJedis(jedis);

        return uvData;
    }
}
