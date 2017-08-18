package com.mitch.netty;

import io.netty.channel.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/8/16.
 */
@Component
public class APIHandler extends ChannelInboundHandlerAdapter {
    Logger logger = Logger.getLogger(APIHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info(String.format("有新的客户端连接,对方地址[%s]...",ctx.channel().remoteAddress()));
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String massage = (String) msg;
        logger.info(String.format("接收到客户端的消息[%s]",massage));


    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
