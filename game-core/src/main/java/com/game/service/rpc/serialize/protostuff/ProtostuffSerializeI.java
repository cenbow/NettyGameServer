package com.game.service.rpc.serialize.protostuff;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.springframework.stereotype.Service;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.game.service.rpc.serialize.IRpcSerialize;

/**
 * 功能模块
 * @author JiangBangMing
 *
 * 2018年6月5日 下午2:14:04
 */
@Service
public class ProtostuffSerializeI implements IRpcSerialize {
	
	private Map<Class<?>, Schema<?>> cachedSchema=new ConcurrentHashMap<>();
	
	private Objenesis objenesis=new ObjenesisStd(true);

	@SuppressWarnings("unchecked")
	private <T> Schema<T> getSchema(Class<T> cls){
		Schema<T> schema=(Schema<T>)cachedSchema.get(cls);
		if(null==schema) {
			schema=RuntimeSchema.createFrom(cls);
			if(schema!=null) {
				cachedSchema.put(cls, schema);
			}
		}
		return schema;
	}
	/**
	 * 序列化（对象->字节数组）
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> byte[] serialize(T obj) {
		Class<T> cls=(Class<T>)obj.getClass();
		LinkedBuffer buffer=LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
		try {
			Schema<T> schema=getSchema(cls);
			return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
		}catch(Exception e) {
			throw new IllegalStateException(e.getMessage(),e);
		}finally {
			buffer.clear();
		}
	}
	/**
	 * 反序列化(字节数组->对象)
	 */
	@Override
	public <T> T deserialize(byte[] data, Class<T> cls) {
		try {
			T message=(T) objenesis.newInstance(cls);
			Schema<T> schema=getSchema(cls);
			ProtostuffIOUtil.mergeFrom(data, message, schema);
			return message;
		}catch(Exception e) {
			throw new IllegalStateException(e.getMessage(),e);
		}
	}
	/**
	 * 生成对象
	 * @param cls
	 * @return
	 */
	public <T> T newInstance(Class<T> cls) {
		try {
			T message=(T)objenesis.newInstance(cls);
			return message;
		}catch(Exception e) {
			throw new IllegalStateException(e.getMessage(),e);
		}
	}
}
