package cn.xpleaf.springmvc.service.impl;

import cn.xpleaf.springmvc.dao.InfoDao;
import cn.xpleaf.springmvc.dao.impl.InfoDaoImpl;
import cn.xpleaf.springmvc.service.InfoService;

import java.util.List;
import java.util.Map;

/**
 * 获取网站信息service实现类
 */
public class InfoServiceImpl implements InfoService {

    private InfoDao infoDao = new InfoDaoImpl();

    @Override
    public List<Map<String, String>> getPV(String dateStr) {

        List<Map<String, String>> pvData = infoDao.getPV(dateStr);

        return pvData;
    }

    @Override
    public List<Map<String, String>> getUV(String dateStr) {
        List<Map<String, String>> uvData = infoDao.getUV(dateStr);

        return uvData;
    }

}
