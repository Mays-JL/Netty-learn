package maysjl.com.cn.nettydemo.domain;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-11 10:10
 **/
public class ClientMsgProtocol {
    //1请求个人信息 2发送聊天信息
    private int type;
    // 消息
    private String msgInfo;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }
}
