package maysjl.com.cn.nettydemo.util;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @program: netty-demo
 * @description:消息传输协议
 * @author: May's_JL
 * @create: 2025-11-11 10:10
 **/
public class ChannelHandler {
    //用于存放用户Channel信息，也可以建立map结构模拟不同的消息群
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
