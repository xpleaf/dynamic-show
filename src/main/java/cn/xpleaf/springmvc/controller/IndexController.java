package cn.xpleaf.springmvc.controller;

import cn.xpleaf.springmvc.service.InfoService;
import cn.xpleaf.springmvc.service.impl.InfoServiceImpl;
import cn.xpleaf.springmvc.utils.ProvinceUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    private InfoService infoService = new InfoServiceImpl();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    private Gson gson = new Gson();

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {

        String dateStr = sdf.format(new Date());
        // 查询获得pv数据和uv数据
        List<Map<String, String>> pvData = infoService.getPV(dateStr);
        List<Map<String, String>> uvData = infoService.getUV(dateStr);
        // 将pvData和uvData转换为json格式字符串
        String pvDataJson = gson.toJson(pvData);
        String uvDataJson = gson.toJson(uvData);
        // 找到最大和最小的pv值
        List<String> minMaxPV = ProvinceUtil.getMinMaxPV(pvData);
        String minPV = minMaxPV.get(0);
        String maxPV = minMaxPV.get(1);
        // 向jsp中传递值
        request.setAttribute("pvDataJson", pvDataJson);
        request.setAttribute("uvDataJson", uvDataJson);
        request.setAttribute("minPV", minPV);
        request.setAttribute("maxPV", maxPV);
        request.setAttribute("dateStr", dateStr);
        // 返回页面
        return "showIndex";
    }
}
