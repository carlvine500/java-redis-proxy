package com.zhh.redis.client;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import com.zhh.redis.command.RedisReply;

public class RedisRequestEncoder extends OneToOneEncoder {

	@Override
	protected Object encode(ChannelHandlerContext ctx, Channel channel,
			Object msg) throws Exception {
		if(msg != null && msg instanceof RedisReply){
			RedisReply reply = (RedisReply)msg;
			return reply.encode();
		}
		return msg;
	}

}
