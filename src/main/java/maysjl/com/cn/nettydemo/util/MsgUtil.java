package maysjl.com.cn.nettydemo.util;

import com.alibaba.fastjson.JSON;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import maysjl.com.cn.nettydemo.domain.*;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-06 12:05
 **/
public class MsgUtil {

    public static TextWebSocketFrame buildMsgAll(String channelId, String msgInfo){
        // 模拟头像
        int i = Math.abs(channelId.hashCode()) % 10;

        ServerMsgProtocol msg = new ServerMsgProtocol();
        msg.setType(2);
        msg.setChannelId(channelId);
        msg.setUserHeadImg("head"+i+".jpg");
        msg.setMsgInfo(msgInfo);

        return new TextWebSocketFrame(JSON.toJSONString(msg));
    }


    public static TextWebSocketFrame buildMsgOwner(String channelId){
        ServerMsgProtocol msg = new ServerMsgProtocol();
        msg.setType(1);
        msg.setChannelId(channelId);
        return new TextWebSocketFrame(JSON.toJSONString(msg));
    }
}
