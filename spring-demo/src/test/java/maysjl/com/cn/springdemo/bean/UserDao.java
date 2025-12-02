package maysjl.com.cn.springdemo.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-12-02 10:40
 **/
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001","小傅哥");
        hashMap.put("10002","May‘sJL");
        hashMap.put("10003","阿毛");
    }

    public String queryUserName(String uId){
        return hashMap.get(uId);
    }
}
