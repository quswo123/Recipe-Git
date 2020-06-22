package com.recipe.control;

import java.io.IOException;
import java.net.ServerSocket;

public class CustomerAcceptThread implements Runnable{
	private static final int CUSTOMER_PORT = 1025; //Customer Client와의 연결은 1025번 포트를 사용한다.
	private ServerSocket ss;
	
	/**
	 * Customer Client와의 연결을 대기하기 위해
	 * 1025번 포트로 ServerSocket을 생성한다.
	 */
	public CustomerAcceptThread() {
		try {
			ss = new ServerSocket(CUSTOMER_PORT);
			System.out.println(CUSTOMER_PORT + " 포트 열기 성공");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 이 Thread는 Customer Client와의 연결을 생성하고, Client와 정보를 주고받는 Front Thread를 생성하는 작업을 수행한다.
	 */
	@Override
	public void run() {
		try {
			while(true) {
				//Client와 연결 및 Front Thread 생성
				Thread customerFrontThread = new Thread(new CustomerFrontThread(ss.accept()));
				customerFrontThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
