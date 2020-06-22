package com.recipe.control;

import java.net.Socket;

public class AdminFrontThread implements Runnable{
	private Socket client;
	
	public AdminFrontThread(Socket s) {
		client = s;
	}
	
	@Override
	public void run() {
		
	}
	
}
