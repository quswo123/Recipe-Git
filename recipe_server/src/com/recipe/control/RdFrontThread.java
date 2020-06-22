package com.recipe.control;

import java.net.Socket;

public class RdFrontThread implements Runnable{
	private Socket client;
	
	public RdFrontThread(Socket s) {
		client = s;
	}
	
	@Override
	public void run() {
		
	}

}
