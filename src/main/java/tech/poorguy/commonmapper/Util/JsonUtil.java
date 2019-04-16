package tech.poorguy.commonmapper.Util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 13:52
 */
public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //忽略json字符串中存在而java对象中实际没有的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    public static String object2Json(Object object){
        if(object==null){
            return null;
        }
        String s=null;
        try {
            s=mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static <T>List<String> listObject2ListJson(List<T> objects){
        if(objects==null){
            return null;
        }
        List<String> list = new ArrayList<String>();
        for(T t:objects){
            list.add(JsonUtil.object2Json(t));
        }
        return list;
    }
    public static <T> List<T> listJson2ListObject(List<String> jsons, Class<T> c) {
        if (jsons == null)
            return null;

        List<T> ts = new ArrayList<T>();
        for (String j : jsons) {
            ts.add(JsonUtil.json2Object(j, c));
        }

        return ts;
    }

    public static <T> T json2Object(String json, Class<T> c) {
        if (StringUtils.hasLength(json) == false)
            return null;

        T t = null;
        try {
            t = mapper.readValue(json, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    @SuppressWarnings("unchecked")
    public static <T> T json2Object(String json, TypeReference<T> tr) {
        if (StringUtils.hasLength(json) == false)
            return null;

        T t = null;
        try {
            t = (T) mapper.readValue(json, tr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) t;
    }
}
