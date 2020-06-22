package com.recipe.control;

public class ServerMain {

	public static void main(String[] args) {
		Thread customerAcceptThread = new Thread(new CustomerAcceptThread()); //Customer Client와의 연결을 생성할 Thread
		Thread rdAcceptThread = new Thread(new RdAcceptThread()); //R&D Client와의 연결을 생성할 Thread
		Thread adminAcceptThread = new Thread(new AdminAcceptThread()); //Admin Client와의 연결을 생성할 Thread
		
		customerAcceptThread.start();
		rdAcceptThread.start();
		adminAcceptThread.start();
	}

}
