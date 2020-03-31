package com.dh.websocket;

import javax.websocket.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dh.dao.PictureDao;


public class MyThread implements Runnable {

	private String id;
	private int sum;// 第一次的数量
	private int new_sum;// 最新一次的数量
	private boolean stopMe = true;// 关闭
	private Session session;

	public void stopMe() {
		stopMe = false;
	}
	
	public MyThread(String id, Session session) {
		this.id=id;
		this.session = session;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-mybatis.xml");
			PictureDao c = (PictureDao) context.getBean("pictureDao");
			
	        sum=c.selectCountPic(id);
	        WebSocketTest wbs=new WebSocketTest();
	        while(stopMe){
	            new_sum=c.selectCountPic(id);
	            if(sum!=new_sum){
	                System.out.println("change");
	                sum=new_sum;
				wbs.onMessage("最新数量:" + sum, id, session);
	            }
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    }
	}


