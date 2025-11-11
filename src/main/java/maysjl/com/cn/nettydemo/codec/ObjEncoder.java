//package maysjl.com.cn.nettydemo.codec;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.handler.codec.MessageToByteEncoder;
//import maysjl.com.cn.nettydemo.util.SerializationUtil;
//
///**
// * @program: netty-demo
// * @description:
// * @author: May's_JL
// * @create: 2025-11-08 21:49
// **/
//public class ObjEncoder extends MessageToByteEncoder {
//
//    private Class<?> genericClass;
//
//    public ObjEncoder(Class<?> genericClass){
//        this.genericClass = genericClass;
//    }
//
//    @Override
//    protected void encode(ChannelHandlerContext ctx, Object in, ByteBuf out) {
//        if (genericClass.isInstance(in) ) {
//            byte[] data = SerializationUtil.serialize(in);
//            out.writeInt(data.length);
//            out.writeBytes(data);
//        }
//    }
//}
