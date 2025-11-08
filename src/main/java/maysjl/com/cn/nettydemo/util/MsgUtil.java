package maysjl.com.cn.nettydemo.util;

import maysjl.com.cn.nettydemo.domain.MsgBody;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-06 12:05
 **/
public class MsgUtil {

    public static MsgBody buildMsg(String channelId, String msgInfo){
        MsgBody.Builder msg = MsgBody.newBuilder();
        msg.setChannelId(channelId);
        msg.setMsgInfo(msgInfo);
        return msg.build();
    }
}
