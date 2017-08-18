package com.mitch.netty;

import com.mitch.chain.RequestChain;
import com.mitch.constants.APIConstants;
import com.mitch.exception.APIException;
import com.mitch.netty.massage.Request;
import com.mitch.netty.massage.RequestDecoder;
import com.mitch.netty.massage.Response;
import com.mitch.netty.massage.ResponseDecoder;
import com.mitch.utils.SpringContextUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/8/16.
 */
@Component
public class APIHandler extends ChannelInboundHandlerAdapter {
    Logger logger = Logger.getLogger(APIHandler.class);
    @Resource
    private RequestDecoder requestDecoder;
    @Resource
    private RequestChain requestChain;
    @Resource
    private ResponseDecoder responseDecoder;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info(String.format("有新的客户端连接,对方地址[%s]...",ctx.channel().remoteAddress()));
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = (String) msg;
        logger.info(String.format("接收到客户端的消息[%s]",message));
        logger.info(String.format("SPring上下文[%s]", SpringContextUtil.getApplicationContext()));
        Response response = null;
        Request request = null;
        try{
            //解析报文
            request = requestDecoder.decode(message);
            requestChain.setRequest(request);
            //执行链
            response = requestChain.handle();
        }catch (APIException e){
            logger.error("api业务异常",e);

            if(response == null){
                response = new Response();
            }
            response.setErrcode(APIConstants.BUSI_EXCEPTION);
            response.setErrmsg(e.getMessage());
        }catch (Exception e){
            logger.error("api系统异常",e);

            throw new RuntimeException("api系统异常",e);
        }
        response.setMassage(responseDecoder.encode(response));

    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    public RequestDecoder getRequestDecoder() {
        return requestDecoder;
    }

    public void setRequestDecoder(RequestDecoder requestDecoder) {
        this.requestDecoder = requestDecoder;
    }

    public RequestChain getRequestChain() {
        return requestChain;
    }

    public void setRequestChain(RequestChain requestChain) {
        this.requestChain = requestChain;
    }

    public ResponseDecoder getResponseDecoder() {
        return responseDecoder;
    }

    public void setResponseDecoder(ResponseDecoder responseDecoder) {
        this.responseDecoder = responseDecoder;
    }
}
