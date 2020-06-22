package com.recipe.view;

import java.util.Scanner;

import com.recipe.io.DataIO;

public class LoginView {
	private String id;
	private String pwd;
	
	public LoginView() {
		
	}
	
	public void printLoginView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.아이디를 입력하세요 : ");
		id = sc.nextLine();
		System.out.println("2.비밀번호를 입력하세요 : ");
		pwd = sc.nextLine();
	}
	
	public void login(String id, String pwd) {
		
	}
}
