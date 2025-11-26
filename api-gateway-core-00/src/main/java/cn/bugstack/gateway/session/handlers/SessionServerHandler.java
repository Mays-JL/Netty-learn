package cn.bugstack.gateway.session.handlers;

import cn.bugstack.gateway.bind.IGenericReference;
import cn.bugstack.gateway.session.BaseHandler;
import cn.bugstack.gateway.session.Configuration;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: netty-demo
 * @description: 会话服务处理器
 * @author: May's_JL
 * @create: 2025-11-26 10:18
 **/
public class SessionServerHandler extends BaseHandler<FullHttpRequest> {

    private final Logger logger = LoggerFactory.getLogger(SessionServerHandler.class);

    private final Configuration configuration;

    public SessionServerHandler(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    protected void session(ChannelHandlerContext ctx, Channel channel, FullHttpRequest request) {
        logger.info("网关接收请求 uri:{} method:{}",request.uri(), request.method());

        // 返回信息控制，简单处理
        String methodName = request.uri().substring(1);
        if ("favicon.ico".equals(methodName)) return;

        // 返回信息处理
        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);

        //服务泛化调用
        IGenericReference reference = configuration.getGenericReference("sayHi");
        String result = reference.$invoke("test") + " " + System.currentTimeMillis();

        //设置写回数据
        response.content().writeBytes(JSON.toJSONBytes(result, SerializerFeature.PrettyFormat));

        //头部设置
        HttpHeaders headers = response.headers();
        // 返回内容类型
        headers.add(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON + "; charset=UTF-8");
        // 响应体的长度
        headers.add(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        // 配置持久连接
        headers.add(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        // 配置跨域访问
        headers.add(HttpHeaderNames.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        headers.add(HttpHeaderNames.ACCESS_CONTROL_ALLOW_HEADERS,"*");
        headers.add(HttpHeaderNames.ACCESS_CONTROL_ALLOW_METHODS,"GET, POST, PUT, DELETE");
        headers.add(HttpHeaderNames.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");

        channel.writeAndFlush(response);
    }
}
