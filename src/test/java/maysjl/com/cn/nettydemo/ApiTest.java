package maysjl.com.cn.nettydemo;

import com.googlecode.protobuf.format.JsonFormat;
import maysjl.com.cn.nettydemo.domain.MsgBody;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-06 11:11
 **/
public class ApiTest {
    public static void main(String[] args) throws JsonFormat.ParseException {
        MsgBody.Builder msg = MsgBody.newBuilder();
        msg.setChannelId("abD01223");
        msg.setMsgInfo("hi helloword");
        MsgBody msgBody = msg.build();

        // protobuf 转JSON 需要引入 protobuf-java-format
        String msgBodyStr = JsonFormat.printToString(msgBody);
        System.out.println(msgBodyStr);

        //json 转 protobuf 需要引入 protobuf-java-format
        JsonFormat.merge("{\"channelId\": \"HBdhi993\",\"msgInfo\": \"hi maysjl.com.cn\"}", msg);
        msgBody = msg.build();
        System.out.println(msgBody.getChannelId());
        System.out.println(msgBody.getMsgInfo());
    }
}
