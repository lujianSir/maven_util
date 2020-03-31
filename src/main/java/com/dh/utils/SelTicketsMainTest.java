package com.dh.utils;

public class SelTicketsMainTest {

	public static void main(String[] args) {
		System.err.println("线程开始");
		SaleTickets st = new SaleTickets();
		for (int i = 0; i < 3; i++) {
			new Thread(st, "窗口" + i).start();
			try {
				new Thread(st, "窗口" + i).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.err.println("结束");
	}
}
