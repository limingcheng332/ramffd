package com.mitch.netty;

import com.mitch.config.ServerConfigBean;
import com.mitch.utils.SpringContextUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/8/16.
 */
public class APIServer {
    private ServerConfigBean serverConfigBean = SpringContextUtil.getBean("serverConfigBean");
    private Logger logger = Logger.getLogger(APIServer.class);
    public void start(){
        String port = serverConfigBean.getServerPort();
        // 配置NIO线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();// 连接线程
        EventLoopGroup workerGroup = new NioEventLoopGroup();// 处理线程组

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ByteBuf delimiter= Unpooled.copiedBuffer("$_".getBytes());//指定消息分割符处理数据
                    socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));//如果取消了分割符解码，就会出现TCP粘包之类的问题了
                    socketChannel.pipeline().addLast(new StringDecoder());
                    socketChannel.pipeline().addLast(new APIHandler());
                }
            });
            logger.info(String.format("------------------服务器端口已绑定[%s]-------------------",port));
            // 绑定端口，同步等待成功
            ChannelFuture future = bootstrap.bind(Integer.parseInt(port)).sync();
            // 等待服务端监听端口关闭，等待服务端链路关闭之后main函数才退出
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
