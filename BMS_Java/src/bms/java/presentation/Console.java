package bms.java.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
	
	// �Է� ���ڿ� ó��
	public static String input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.print("�Է�> ");
		
		try {
			str = br.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	// ���� ������ ġȯ
	public static int getRandNo() {
		int randNo = (int) (Math.random() * 100000 + 1);
		return randNo;
	}
	
	// �Է� ��ȿ�� �˻�
	public static boolean getChkNo(String input) {
		return input.matches("^[0-9]*$");
	}

}
