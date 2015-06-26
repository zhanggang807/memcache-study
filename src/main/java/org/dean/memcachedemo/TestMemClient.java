package org.dean.memcachedemo;

import java.util.ArrayList;
import java.util.Date;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class TestMemClient {
	
	private static MemCachedClient client = new MemCachedClient();

	static {
		String[] servers = {"10.10.24.30:11211" };
		Integer[] weights = {1 };
		SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(servers);
		pool.setWeights(weights);
		pool.setNagle(false);
		pool.setSocketTO(3000);
		pool.setSocketConnectTO(10);
		pool.initialize();
//		client.setTransCoder(new ObjectTransCoder());
	}
	
	public static void main(String[] args) {
		System.out.println("add name---" + client.add("name", "dean"));
		System.out.println("add age---" + client.add("age", 30));
		System.out.println("add address---" + client.add("address", "road 1,street 2"));
		
		System.out.println("get name---" + client.get("name"));
		System.out.println("get age---" + client.get("age"));
		System.out.println("get address---" + client.get("address"));
		
		System.out.println("---------------another client-----------");
		MemCachedClient clientAno = new MemCachedClient();
		System.out.println(clientAno.add("email", "z@qq.com"));
		System.out.println("get email---" + client.get("email"));
		//说明你实例化多少个客户端都是一样的，都是在池子里取的没有关系，不写单例也没有关系
		
		System.out.println("---------------specific pojo-----------");
		System.out.println("set test key---" + client.set("test", new ArrayList<String>().add("testKey"), 10));
//		System.out.println("get test key---" + (ArrayList<String>)client.get("test"));//???????
		//为什么不能放集合类型，他们已经实现在序列化接口呀
		
		System.out.println("set user---" + client.set("user", new User(), new Date(System.currentTimeMillis() + 10 * 1000)));//加入缓存过期时间10
		System.out.println("get user---" + (User)client.get("user"));
		
//		client.flushAll();
		
	}
	

}