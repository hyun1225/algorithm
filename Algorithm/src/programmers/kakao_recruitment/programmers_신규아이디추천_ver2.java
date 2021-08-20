package programmers.kakao_recruitment;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class programmers_신규아이디추천_ver2 {
	

	//static String newId;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/programmers_input/programmers_input_신규아이디추천.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String newId = br.readLine();

		String answer = "";

		String temp = newId.toLowerCase();
		for (int i = 0; i < temp.length(); i++) {
			Character c = temp.charAt(i);
			if (((c - 'a') >= 0 && (c - 'a') < 26) || c == '-' || c == '_' || c == '.' || Character.isDigit(c)) {
				answer += Character.toString(c);
			}
		}

		while (answer.indexOf("..") >= 0) {
			answer = answer.replace("..", ".");
		}

		if (answer.charAt(0) == '.') {
			answer = answer.substring(1, answer.length());
		}
		if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
			answer = answer.substring(0, answer.length() - 1);
		}

		if (answer.equals("")) {
			answer = "a";
		}

		if (answer.length() >= 16) {
			answer = answer.substring(0, 15);
			if (answer.length() > 0 && answer.charAt(14) == '.') {
				answer = answer.substring(0, 14);
			}
		}

		if (answer.length() <= 2) {
			Character c = answer.charAt(answer.length() - 1);

			while (answer.length() != 3) {
				answer += Character.toString(c);
			}
		}
		
		System.out.println(answer);

	}
	
}

