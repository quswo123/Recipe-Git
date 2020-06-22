package com.recipe.view;

import java.util.Scanner;

public class MainView {
	Scanner sc;
	
	public MainView() {
		sc = new Scanner(System.in);
	}
	
	public void mainMenu() {
		int menu = -1;
		do {
			System.out.println("1.레시피검색 2.추천레시피 3.로그인 4.회원가입 0.프로그램 종료");
			menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				LoginView loginView = new LoginView();
				//여기부터 할거임
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				menu = -1;
				break;	
			}
		}while(menu != 0);
	}
	
	public static void main(String[] args) {

	}

}
