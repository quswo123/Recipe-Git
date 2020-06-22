package com.recipe.control;

public class ServerMain {

	/**
	 * main에서는 각 클라이언트와의 연결을 생성하는 Thread들을 생성한다.
	 * @param args
	 */
	public static void main(String[] args) {
		Thread customerAcceptThread = new Thread(new CustomerAcceptThread()); //Customer Client와의 연결을 생성할 Thread
		Thread rdAcceptThread = new Thread(new RdAcceptThread()); //R&D Client와의 연결을 생성할 Thread
		Thread adminAcceptThread = new Thread(new AdminAcceptThread()); //Admin Client와의 연결을 생성할 Thread
		
		customerAcceptThread.start();
		rdAcceptThread.start();
		adminAcceptThread.start();
	}

}
