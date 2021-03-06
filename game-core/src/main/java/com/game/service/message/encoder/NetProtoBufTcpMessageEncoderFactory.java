package com.game.service.message.encoder;

import org.springframework.stereotype.Service;

import com.game.service.message.AbstractNetProtoBufMessage;
import com.game.service.message.NetMessageBody;
import com.game.service.message.NetMessageHead;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 
 * @author JiangBangMing
 *
 * 2018年6月5日 下午3:22:41
 */
@Service
public class NetProtoBufTcpMessageEncoderFactory implements INetProtoBufTcpMessageEncoderFactory{

	@Override
	public ByteBuf createByteBuf(AbstractNetProtoBufMessage netMessage) throws Exception {
		ByteBuf byteBuf=Unpooled.buffer(256);
		//编写head
		NetMessageHead netMessageHead=netMessage.getNetMessageHead();
		byteBuf.writeShort(netMessageHead.getHead());
		//长度
		byteBuf.writeInt(0);
		//设置内容
		byteBuf.writeByte(netMessageHead.getVersion());
		byteBuf.writeShort(netMessageHead.getCmd());
		byteBuf.writeInt(netMessageHead.getSerial());
		
		//编写body
		netMessage.encodeNetProtoBufMessageBody();
		NetMessageBody netMessageBody=netMessage.getNetMessageBody();
		byteBuf.writeBytes(netMessageBody.getBytes());
		
		//重新设置长度
		int skip=6;
		int length=byteBuf.readableBytes()-skip;
		byteBuf.setIndex(2, length);
		byteBuf.slice();
		
		return byteBuf;
	}

}
