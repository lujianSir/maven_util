package com.dh.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/WebSocketTest/{param}")
public class WebSocketTest {

	// 用来存放每个客户端对应的MyWebSocket对象。
	private static CopyOnWriteArraySet<WebSocketTest> webSocketSet = new CopyOnWriteArraySet<WebSocketTest>();
	
	private Session session;

	private MyThread thread1;

	// 存放用户的id与session关系
	private static HashMap<String, List<Session>> map = new HashMap<String, List<Session>>();

	@OnOpen // 打开连接执行
	public void onOpw(@PathParam(value = "param") String param, Session session) {
		thread1 = new MyThread(param,session);
		Thread thread = new Thread(thread1);
		this.session = session;
		webSocketSet.add(this);
		List<Session> list = map.get(param);
		if (list != null && list.size() > 0) {
			list.add(session);
		} else {
			list = new ArrayList<Session>();
			list.add(session);
			map.put(param, list);
		}

		System.out.println("打开了连接");
		System.out.println(param);
		// 开启一个线程对数据库中的数据进行轮询
		thread.start();
	}

	@OnMessage // 收到消息执行
	public void onMessage(String message, @PathParam(value = "param") String param,Session session) {
		System.out.println(message);
		try {
			sendMessage(message, param, session);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@OnClose // 关闭连接执行
	public void onClose(Session session, @PathParam(value = "param") String param) {
		thread1.stopMe();
		webSocketSet.remove(this);
		List<Session> list = map.get(param);
		int length = list.size();
		for (int i = 0; i < length; i++) {
			if (list.get(i) == session) {
				list.remove(i);
			}
		}
		System.out.println("关闭连接");
	}

	@OnError // 连接错误的时候执行
	public void onError(Throwable error, Session session) {
		System.out.println("错误的时候执行");
		error.printStackTrace();
	}

	/*
	 * websocket session发送文本消息有两个方法：getAsyncRemote()和 getBasicRemote()
	 * getAsyncRemote()和getBasicRemote()是异步与同步的区别， 大部分情况下，推荐使用getAsyncRemote()。
	 */
	public void sendMessage(String message, @PathParam(value = "param") String param, Session session)
			throws IOException {
		// this.session.getAsyncRemote().sendText(message);
		// 群发消息
		// for (WebSocketTest item : webSocketSet) {
		// item.session.getAsyncRemote().sendText(message);
		// }
		List<Session> list = map.get(param);
		for (Session s : list) {
			if (s == session) {
				s.getAsyncRemote().sendText(message);
			}
		}

	}
}
