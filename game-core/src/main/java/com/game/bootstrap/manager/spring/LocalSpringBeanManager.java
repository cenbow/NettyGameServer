package com.game.bootstrap.manager.spring;
/**
 * 这里都是单例
 * @author JiangBangMing
 *
 * 2018年5月31日 下午8:28:30
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.game.logic.net.NetMessageProcessLogic;
import com.game.logic.net.NetMessageTcpDispatchLogic;
import com.game.service.message.command.MessageCommandFactory;
import com.game.service.message.decoder.NetProtoBufHttpMessageDecoderFactory;
import com.game.service.message.decoder.NetProtoBufTcpMessageDecoderFactory;
import com.game.service.message.decoder.NetProtoBufUdpMessageDecoderFactory;
import com.game.service.message.encoder.NetProtoBufHttpMessageEncoderFactory;
import com.game.service.message.encoder.NetProtoBufTcpMessageEncoderFactory;
import com.game.service.message.encoder.NetProtoBufUdpMessageEncoderFactory;
import com.game.service.message.factory.TcpMessageFactory;
import com.game.service.net.tcp.pipeline.DefaultTcpServerPipeLine;
import com.game.service.net.tcp.pipeline.DefaultUdpServerPipeLine;
import com.game.service.net.tcp.session.builder.NettyTcpSessionBuilder;
import com.game.service.net.tcp.session.builder.NettyUdpSessionBuilder;
import com.game.service.rpc.client.RpcRequestFactory;
import com.game.service.rpc.serialize.protostuff.ProtostuffSerializeI;
import com.game.service.uuid.LongIdGenerator;

@Repository
public class LocalSpringBeanManager {
	
	@Autowired
	private NettyTcpSessionBuilder nettyTcpSessionBuilder;
	
	@Autowired
	private NettyUdpSessionBuilder nettyUdpSessionBuilder;
	
    @Autowired
    private LongIdGenerator longIdGenerator;
    
    @Autowired
    private NetMessageTcpDispatchLogic netMessageTcpDispatchLogic;
    
    @Autowired
    private NetMessageProcessLogic netMessageProcessLogic;
    
    @Autowired
    private DefaultTcpServerPipeLine defaultTcpServerPipeLine;
    
    @Autowired
    private DefaultUdpServerPipeLine defaultUdpServerPipeLine;
    
    @Autowired
    private TcpMessageFactory tcpMessageFactory;
    
	@Autowired
	private ProtostuffSerializeI protostuffSerialize;
	
	@Autowired
	private RpcRequestFactory requestFactory;
    
	@Autowired
	private MessageCommandFactory messageCommandFactory;
	
	@Autowired
	private NetProtoBufTcpMessageDecoderFactory netProtoBufTcpMessageDecoderFactory;
	
	@Autowired
	private NetProtoBufUdpMessageDecoderFactory netProtoBufUdpMessageDecoderFactory;

    @Autowired
    private NetProtoBufTcpMessageEncoderFactory netProtoBufTcpMessageEncoderFactory;
    
    @Autowired
    private NetProtoBufUdpMessageEncoderFactory netProtoBufUdpMessageEncoderFactory;
    
    @Autowired
    private NetProtoBufHttpMessageDecoderFactory netProtoBufHttpMessageDecoderFactory;

    @Autowired
    private NetProtoBufHttpMessageEncoderFactory netProtoBufHttpMessageEncoderFactory;

	public NettyTcpSessionBuilder getNettyTcpSessionBuilder() {
		return nettyTcpSessionBuilder;
	}

	public void setNettyTcpSessionBuilder(NettyTcpSessionBuilder nettyTcpSessionBuilder) {
		this.nettyTcpSessionBuilder = nettyTcpSessionBuilder;
	}

	public NettyUdpSessionBuilder getNettyUdpSessionBuilder() {
		return nettyUdpSessionBuilder;
	}

	public void setNettyUdpSessionBuilder(NettyUdpSessionBuilder nettyUdpSessionBuilder) {
		this.nettyUdpSessionBuilder = nettyUdpSessionBuilder;
	}

	public LongIdGenerator getLongIdGenerator() {
		return longIdGenerator;
	}

	public void setLongIdGenerator(LongIdGenerator longIdGenerator) {
		this.longIdGenerator = longIdGenerator;
	}

	public NetMessageTcpDispatchLogic getNetMessageTcpDispatchLogic() {
		return netMessageTcpDispatchLogic;
	}

	public void setNetMessageTcpDispatchLogic(NetMessageTcpDispatchLogic netMessageTcpDispatchLogic) {
		this.netMessageTcpDispatchLogic = netMessageTcpDispatchLogic;
	}

	public NetMessageProcessLogic getNetMessageProcessLogic() {
		return netMessageProcessLogic;
	}

	public void setNetMessageProcessLogic(NetMessageProcessLogic netMessageProcessLogic) {
		this.netMessageProcessLogic = netMessageProcessLogic;
	}

	public DefaultTcpServerPipeLine getDefaultTcpServerPipeLine() {
		return defaultTcpServerPipeLine;
	}

	public void setDefaultTcpServerPipeLine(DefaultTcpServerPipeLine defaultTcpServerPipeLine) {
		this.defaultTcpServerPipeLine = defaultTcpServerPipeLine;
	}

	public DefaultUdpServerPipeLine getDefaultUdpServerPipeLine() {
		return defaultUdpServerPipeLine;
	}

	public void setDefaultUdpServerPipeLine(DefaultUdpServerPipeLine defaultUdpServerPipeLine) {
		this.defaultUdpServerPipeLine = defaultUdpServerPipeLine;
	}

	public TcpMessageFactory getTcpMessageFactory() {
		return tcpMessageFactory;
	}

	public void setTcpMessageFactory(TcpMessageFactory tcpMessageFactory) {
		this.tcpMessageFactory = tcpMessageFactory;
	}

	public ProtostuffSerializeI getProtostuffSerialize() {
		return protostuffSerialize;
	}

	public void setProtostuffSerialize(ProtostuffSerializeI protostuffSerialize) {
		this.protostuffSerialize = protostuffSerialize;
	}

	public RpcRequestFactory getRequestFactory() {
		return requestFactory;
	}

	public void setRequestFactory(RpcRequestFactory requestFactory) {
		this.requestFactory = requestFactory;
	}

	public MessageCommandFactory getMessageCommandFactory() {
		return messageCommandFactory;
	}

	public void setMessageCommandFactory(MessageCommandFactory messageCommandFactory) {
		this.messageCommandFactory = messageCommandFactory;
	}

	public NetProtoBufTcpMessageDecoderFactory getNetProtoBufTcpMessageDecoderFactory() {
		return netProtoBufTcpMessageDecoderFactory;
	}

	public void setNetProtoBufTcpMessageDecoderFactory(
			NetProtoBufTcpMessageDecoderFactory netProtoBufTcpMessageDecoderFactory) {
		this.netProtoBufTcpMessageDecoderFactory = netProtoBufTcpMessageDecoderFactory;
	}

	public NetProtoBufUdpMessageDecoderFactory getNetProtoBufUdpMessageDecoderFactory() {
		return netProtoBufUdpMessageDecoderFactory;
	}

	public void setNetProtoBufUdpMessageDecoderFactory(
			NetProtoBufUdpMessageDecoderFactory netProtoBufUdpMessageDecoderFactory) {
		this.netProtoBufUdpMessageDecoderFactory = netProtoBufUdpMessageDecoderFactory;
	}

	public NetProtoBufTcpMessageEncoderFactory getNetProtoBufTcpMessageEncoderFactory() {
		return netProtoBufTcpMessageEncoderFactory;
	}

	public void setNetProtoBufTcpMessageEncoderFactory(
			NetProtoBufTcpMessageEncoderFactory netProtoBufTcpMessageEncoderFactory) {
		this.netProtoBufTcpMessageEncoderFactory = netProtoBufTcpMessageEncoderFactory;
	}

	public NetProtoBufUdpMessageEncoderFactory getNetProtoBufUdpMessageEncoderFactory() {
		return netProtoBufUdpMessageEncoderFactory;
	}

	public void setNetProtoBufUdpMessageEncoderFactory(
			NetProtoBufUdpMessageEncoderFactory netProtoBufUdpMessageEncoderFactory) {
		this.netProtoBufUdpMessageEncoderFactory = netProtoBufUdpMessageEncoderFactory;
	}

	public NetProtoBufHttpMessageDecoderFactory getNetProtoBufHttpMessageDecoderFactory() {
		return netProtoBufHttpMessageDecoderFactory;
	}

	public void setNetProtoBufHttpMessageDecoderFactory(
			NetProtoBufHttpMessageDecoderFactory netProtoBufHttpMessageDecoderFactory) {
		this.netProtoBufHttpMessageDecoderFactory = netProtoBufHttpMessageDecoderFactory;
	}

	public NetProtoBufHttpMessageEncoderFactory getNetProtoBufHttpMessageEncoderFactory() {
		return netProtoBufHttpMessageEncoderFactory;
	}

	public void setNetProtoBufHttpMessageEncoderFactory(
			NetProtoBufHttpMessageEncoderFactory netProtoBufHttpMessageEncoderFactory) {
		this.netProtoBufHttpMessageEncoderFactory = netProtoBufHttpMessageEncoderFactory;
	}
	
	
}
