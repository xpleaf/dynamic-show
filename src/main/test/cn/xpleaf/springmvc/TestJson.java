package cn.xpleaf.springmvc;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * echarts中的数据格式：
 * data: [
 {name: '北京', value: randomData()},
 {name: '广东', value: randomData()}
 ]
 */
public class TestJson {

    @Test
    public void test1() {
        List<Map<String, String>> data = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("name", "北京");
        map1.put("value", "1365");
        data.add(map1);
        Map<String, String> map2 = new HashMap<>();
        map2.put("name", "广东");
        map2.put("value", "1260");
        data.add(map2);

        // 格式化为json数据
        Gson gson = new Gson();
        String json = gson.toJson(data);

        System.out.println(json);   // [{"name":"北京","value":"1365"},{"name":"广东","value":"1260"}]
    }
}
