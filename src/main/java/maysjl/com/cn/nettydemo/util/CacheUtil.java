package maysjl.com.cn.nettydemo.util;

import maysjl.com.cn.nettydemo.domain.FileBurstInstruct;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-10 17:44
 **/
public class CacheUtil {

    public static Map<String, FileBurstInstruct> burstDataMap = new ConcurrentHashMap<>();
}
