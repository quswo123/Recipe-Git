package com.recipe.control;

import java.io.IOException;
import java.net.ServerSocket;

public class AdminAcceptThread implements Runnable{
	private static final int ADMIN_PORT = 1027;
	private ServerSocket ss;
	
	public AdminAcceptThread() {
		try {
			ss = new ServerSocket(ADMIN_PORT);
			System.out.println(ADMIN_PORT + " 포트 열기 성공");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
	}

}
