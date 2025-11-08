package maysjl.com.cn.nettydemo.util;

import maysjl.com.cn.nettydemo.domain.MsgInfo;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-06 12:05
 **/
public class MsgUtil {

    public static MsgInfo buildMsg(String channelId,String msgContent){
        return new MsgInfo(channelId,msgContent);
    }
}
