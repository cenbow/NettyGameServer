package com.game.service.config;

import java.net.URL;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.game.common.config.ConfigUtil;
import com.game.common.config.GameDynamicPropertiesConfig;
import com.game.common.config.GameServerConfig;
import com.game.common.config.GameServerDiffConfig;
import com.game.common.config.ZooKeeperConfig;
import com.game.common.constant.GlobalConstants;
import com.game.common.constant.ServiceName;
import com.game.service.IService;
import com.game.service.net.http.NetHttpServerConfig;
import com.game.service.net.proxy.NetProxyConfig;
import com.game.service.net.udp.NetUdpServerConfig;
import com.game.service.net.websocket.NetWebSocketServerConfig;
import com.game.service.rpc.server.RpcServerRegisterConfig;

/**
 * 游戏配置服务
 * @author JiangBangMing
 *
 * 2018年6月2日 下午2:11:28
 */
@Service
public class GameServerConfigService implements IService{

	protected GameServerDiffConfig gameServerDiffConfig;
	protected GameServerConfig gameServerConfig;
	protected GameDynamicPropertiesConfig gameDynamicPropertiesConfig;
	protected ZooKeeperConfig zooKeeperConfig;
	protected RpcServerRegisterConfig rpcServerRegisterConfig;
	protected NetProxyConfig netProxyConfig;
	protected NetUdpServerConfig netUdpServerConfig;
	protected NetHttpServerConfig netHttpServerConfig;
	protected NetWebSocketServerConfig netWebSocketServerConfig;
	
	@Override
	public String getId() {
		return ServiceName.GameServerConfigServiceString;
	}

	@Override
	public void startup() throws Exception {
		this.init();
	}
	
	public void init() throws Exception{
		initConfig();
		initDiffConfig();
        initDynamicConfig();
        initRpcConfig();
        initZooKeeperConfig();
        initNetProxyConfig();
        initNetUdpServerConfig();
        initNetHttpServerConfig();
        initWebSocketConfig();
	}
	
	@Override
	public void shutdown() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public GameServerConfig getGameServerConfig() {
		return gameServerConfig;
	}

	public void setGameServerConfig(GameServerConfig gameServerConfig) {
		this.gameServerConfig = gameServerConfig;
	}

	public GameServerDiffConfig getGameServerDiffConfig() {
		return gameServerDiffConfig;
	}

	public void setGameServerDiffConfig(GameServerDiffConfig gameServerDiffConfig) {
		this.gameServerDiffConfig = gameServerDiffConfig;
	}

	public GameDynamicPropertiesConfig getGameDynamicPropertiesConfig() {
		return gameDynamicPropertiesConfig;
	}

	public void setGameDynamicPropertiesConfig(GameDynamicPropertiesConfig gameDynamicPropertiesConfig) {
		this.gameDynamicPropertiesConfig = gameDynamicPropertiesConfig;
	}

	public ZooKeeperConfig getZooKeeperConfig() {
		return zooKeeperConfig;
	}

	public void setZooKeeperConfig(ZooKeeperConfig zooKeeperConfig) {
		this.zooKeeperConfig = zooKeeperConfig;
	}

	public RpcServerRegisterConfig getRpcServerRegisterConfig() {
		return rpcServerRegisterConfig;
	}

	public void setRpcServerRegisterConfig(RpcServerRegisterConfig rpcServerRegisterConfig) {
		this.rpcServerRegisterConfig = rpcServerRegisterConfig;
	}

	public NetUdpServerConfig getNetUdpServerConfig() {
		return netUdpServerConfig;
	}

	public void setNetUdpServerConfig(NetUdpServerConfig netUdpServerConfig) {
		this.netUdpServerConfig = netUdpServerConfig;
	}
	
	
	public NetHttpServerConfig getNetHttpServerConfig() {
		return netHttpServerConfig;
	}

	public void setNetHttpServerConfig(NetHttpServerConfig netHttpServerConfig) {
		this.netHttpServerConfig = netHttpServerConfig;
	}

	
	
	public NetWebSocketServerConfig getNetWebSocketServerConfig() {
		return netWebSocketServerConfig;
	}

	public void setNetWebSocketServerConfig(NetWebSocketServerConfig netWebSocketServerConfig) {
		this.netWebSocketServerConfig = netWebSocketServerConfig;
	}

	private void initConfig() {
		String cfgPath=GlobalConstants.ConfigFile.GAME_SERVER_CONIFG;
		ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
		URL url=classLoader.getResource(cfgPath);
		GameServerConfig gameServerConfig=ConfigUtil.buildConfig(GameServerConfig.class, url);
		this.gameServerConfig=gameServerConfig;
	}
	
	private void initDiffConfig() {
		String cfgPath=GlobalConstants.ConfigFile.GAME_SERVER_DIFF_CONIFG;
		ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
		URL url=classLoader.getResource(cfgPath);
		GameServerDiffConfig gameServerDiffConfig=ConfigUtil.buildConfig(GameServerDiffConfig.class, url);
		this.gameServerDiffConfig=gameServerDiffConfig;
	}
	
	private void initDynamicConfig() {
		DefaultResourceLoader defaultResourceLoader=new DefaultResourceLoader();
		Resource resource=defaultResourceLoader.getResource(GlobalConstants.ConfigFile.DYNAMIC_CONFIG);
		GameDynamicPropertiesConfig gameDynamicPropertiesConfig=new GameDynamicPropertiesConfig();
		gameDynamicPropertiesConfig.setResource(resource);
		gameDynamicPropertiesConfig.init();
		this.gameDynamicPropertiesConfig=gameDynamicPropertiesConfig;
	}
    private void initRpcConfig() throws Exception{
    	RpcServerRegisterConfig rpcServerRegisterConfig=new RpcServerRegisterConfig();
    	rpcServerRegisterConfig.init();
    	this.rpcServerRegisterConfig=rpcServerRegisterConfig;
    }
    private void initZooKeeperConfig() {
    	DefaultResourceLoader defaultResourceLoader=new DefaultResourceLoader();
    	Resource resource=defaultResourceLoader.getResource(GlobalConstants.ConfigFile.ZOOKEEPER_CONFIG);
    	ZooKeeperConfig zooKeeperConfig=new ZooKeeperConfig();
    	zooKeeperConfig.setResource(resource);
    	zooKeeperConfig.init();
    	this.zooKeeperConfig=zooKeeperConfig;
    }
    private void initNetProxyConfig() throws Exception{
    	NetProxyConfig netProxyConfig=new NetProxyConfig();
    	netProxyConfig.init();
    	this.netProxyConfig=netProxyConfig;
    	
    }
    private void initNetUdpServerConfig() throws Exception {
    	NetUdpServerConfig netUdpServerConfig=new NetUdpServerConfig();
    	netUdpServerConfig.init();
    	this.netUdpServerConfig=netUdpServerConfig;
    }
    private void initNetHttpServerConfig() throws Exception{
    	NetHttpServerConfig netHttpServerConfig=new NetHttpServerConfig();
    	netHttpServerConfig.init();
    	this.netHttpServerConfig=netHttpServerConfig;
    }
    private void initWebSocketConfig() throws Exception{
    	NetWebSocketServerConfig netWebSocketServerConfig=new NetWebSocketServerConfig();
    	netWebSocketServerConfig.init();
    	this.netWebSocketServerConfig=netWebSocketServerConfig;
    }
    
}
