package bms.java.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
	
	// 입력 문자열 처리
	public static String input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.print("입력> ");
		
		try {
			str = br.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	// 숫자 무작위 치환
	public static int getRandNo() {
		int randNo = (int) (Math.random() * 100000 + 1);
		return randNo;
	}
	
	// 입력 유효성 검사
	public static boolean getChkNo(String input) {
		return input.matches("^[0-9]*$");
	}

}
