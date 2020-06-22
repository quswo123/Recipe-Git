package com.recipe.control;

import java.net.Socket;

public class CustomerFrontThread implements Runnable{
	private Socket client;
	
	public CustomerFrontThread(Socket s) {
		client = s;
	}
	@Override
	public void run() {
		
	}

}
