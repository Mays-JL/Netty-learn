package cn.bugstack.gateway;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-10 20:40
 **/
public abstract class BaseHandler<T> extends SimpleChannelInboundHandler<T> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, T msg) throws Exception {
        session(ctx, ctx.channel(), msg);
    }

    protected abstract void session(ChannelHandlerContext ctx, final Channel channel, T request);
}
