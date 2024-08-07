package me.occure.common.server.network;

import com.google.common.collect.Maps;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import me.occure.common.server.Server;
import me.occure.common.server.network.packet.ChargeEventClientBoundPacket;
import me.occure.common.server.network.packet.ChargeEventServerBoundPacket;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.logging.Logger;

public class ServerInboundHandler extends ChannelInboundHandlerAdapter {

    private final ChargeEventPacketHandler packetHandler = new ChargeEventPacketHandler();
    private static final Map<String, Channel> channels = Maps.newConcurrentMap();

    @Override
    public void channelActive(@NotNull ChannelHandlerContext ctx) throws Exception {
        channels.put(ctx.channel().remoteAddress().toString(), ctx.channel());
        Logger.getLogger("Network").info("ChannelActive" + channels);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        channels.remove(ctx.channel().remoteAddress().toString(), ctx.channel());
    }

    @Override
    public void channelRead(@NotNull ChannelHandlerContext ctx, @NotNull Object msg) throws Exception {
        try {
            ByteBuf buf = (ByteBuf) msg;
            final int id = buf.readInt();
            if(id == 1){
               ChargeEventServerBoundPacket eventPacket = new ChargeEventServerBoundPacket(buf);
               packetHandler.packetHandler(eventPacket);

                ChargeEventClientBoundPacket packet =
                        new ChargeEventClientBoundPacket(packetHandler.getBootsChecker().isWearingItem());
                String remoteAddress = ctx.channel().remoteAddress().toString();
                Server.sendPacket(remoteAddress, packet.toByteBuf());
            }
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        channels.remove(ctx.channel().remoteAddress().toString());
        ctx.close();
    }
    public static Map<String, Channel> getChannels(){
        return channels;
    }
}
