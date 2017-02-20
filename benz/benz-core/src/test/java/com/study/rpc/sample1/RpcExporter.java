package com.study.rpc.sample1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
* @ClassName: RpcExporter
* @Description: 
* 1.作为服务端监听Tcp连接，接受到用户连接后，将其封装成Task，交给线程处理 
* @author xiaoxu.sxx 
* @date 2017年2月17日 下午3:12:07 
* 
*/
public class RpcExporter {
	static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	public static void exporter(String hostName,int port) throws Exception{
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress(port), port);
		try{
			while(true){
				executor.execute(new ExporterTask(server.accept()));
			}
		}
		finally{
			server.close();
		}
	}
	
	
	
	/** 
	* @ClassName: ExporterTask 
	* @Description: 
	* 2.客户端反序列化成对象，反射调用服务实现者，获取执行结果
	* 3.将执行结果对象反序列化，通过socket发送给客户端
	* 4.远程服务关闭后，释放socket连接，防止句柄泄露
	* @author xiaoxu.sxx 
	* @date 2017年2月17日 下午3:13:05 
	* 
	*/
	private static class ExporterTask implements Runnable{
		Socket client = null;
		public ExporterTask(Socket client){
			this.client = client;
		}
		
		@Override
		public void run() {
			ObjectInputStream input = null;
			ObjectOutputStream output = null;
			
			try {
				input = new ObjectInputStream(client.getInputStream());
				//接口名称
				String interfaceName = input.readUTF();
				Class<?> service = Class.forName(interfaceName);
				//方法名称
				String methodName = input.readUTF();
				//参数
				Class<?>[] parameterTypes = (Class<?>[])input.readObject();
				Object[] arguments = (Object[])input.readObject();
				//获取方法
				Method method = service.getMethod(methodName, parameterTypes);
				//执行方法
				Object result = method.invoke(service.newInstance(), arguments);
				output = new ObjectOutputStream(client.getOutputStream());
				output.writeObject(result);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				if(output != null){
					try {
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(input != null){
					try {
						input.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(client != null){
					try {
						client.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
	}
}
