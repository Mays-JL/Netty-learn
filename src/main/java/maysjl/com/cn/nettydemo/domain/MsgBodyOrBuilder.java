package maysjl.com.cn.nettydemo.domain;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-06 12:03
 **/
public interface MsgBodyOrBuilder extends
        // @@protoc_insertion_point(interface_extends:org.itstack.demo.netty.domain.MsgBody)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string channelId = 1;</code>
     */
    java.lang.String getChannelId();
    /**
     * <code>string channelId = 1;</code>
     */
    com.google.protobuf.ByteString
    getChannelIdBytes();

    /**
     * <code>string msgInfo = 2;</code>
     */
    java.lang.String getMsgInfo();
    /**
     * <code>string msgInfo = 2;</code>
     */
    com.google.protobuf.ByteString
    getMsgInfoBytes();
}
