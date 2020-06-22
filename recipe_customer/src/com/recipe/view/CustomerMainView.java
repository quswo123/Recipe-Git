package com.recipe.view;

import java.util.Scanner;

import com.recipe.io.Menu;

public class CustomerMainView {
	Scanner sc;
	
	public CustomerMainView() {
		sc = new Scanner(System.in);
	}
	
	public void mainMenu() {
		int menu = -1;
		do {
			System.out.println("1.레시피검색 2.추천레시피 3.구매내역 4.즐겨찾기보기 5.나의후기목록 6.내 정보보기 7.로그아웃 8.시스템종료");
			menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1:
				break;
			case 2:
				break;
			case 8:
				break;
			}
		}while(menu != -1);
	}
}
