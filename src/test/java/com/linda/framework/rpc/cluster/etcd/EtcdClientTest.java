package com.linda.framework.rpc.cluster.etcd;

import com.linda.framework.rpc.cluster.HelloRpcService;
import com.linda.framework.rpc.cluster.serializer.ProtostuffSerializer;
import com.linda.framework.rpc.cluster.serializer.simple.SimpleSerializer;

public class EtcdClientTest {
	
	public static void main(String[] args) {
		
		EtcdRpcClient client = new EtcdRpcClient();
		client.setEtcdUrl("http://127.0.0.1:2379");
		client.setNamespace("myapp");
		client.setApplication("test");
		client.setSerializer(new SimpleSerializer());
		client.startService();
		HelloRpcService rpcService = client.register(HelloRpcService.class);
		
		int index = 50000;
		
		while(true){
			rpcService.sayHello("this is rpc etcd test-"+index, index);
			index++;
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
