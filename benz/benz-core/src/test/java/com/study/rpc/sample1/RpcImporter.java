package com.study.rpc.sample1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/** 
* @ClassName: RpcImporter 
* @Description: 1.将本地接口调用转化成Jdk的动态代理，在动态代理中实现接口的远程调用
* @author xiaoxu.sxx 
* @date 2017年2月17日 下午3:43:58 
* 
*/
public class RpcImporter<S> {
	@SuppressWarnings("unchecked")
	public S importer(final Class<?> serviceClass,final InetSocketAddress addr){
		return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(),
				new Class<?>[]{serviceClass.getInterfaces()[0]},
				new Tn(serviceClass,addr));
	}

}
/** 
* @ClassName: Tn 
* @Description: 
* 2.创建socket客户端，根据指定地址连接远程服务调用
* 3.将远程服务调用所需的接口类，方法，参数列表等编码后发送给服务提供者。
* 4.同步阻塞等待服务端返回应答，获取回答之后返回
* @author xiaoxu.sxx 
* @date 2017年2月17日 下午3:45:07 
* 
*/
class Tn implements InvocationHandler{
	
	private Class<?> serviceClass;
	
	private InetSocketAddress addr;
	
	public Tn(Class<?> serviceClass ,InetSocketAddress addr){
		this.serviceClass = serviceClass;
		this.addr = addr;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Socket socket = null;
		ObjectOutputStream output = null;
		ObjectInputStream input = null;
		try{
			socket = new Socket();
			socket.connect(addr);
			output = new ObjectOutputStream(socket.getOutputStream());
			output.writeUTF(serviceClass.getName());
			output.writeUTF(method.getName());
			output.writeObject(method.getParameterTypes());
			output.writeObject(args);
			input = new ObjectInputStream(socket.getInputStream());
			return input.readObject();
		}
		finally{
			if(socket != null){
				socket.close();
			}
			if(output != null){
				output.close();
			}
			if(input != null){
				input.close();
			}
		}
	}
}