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

public class programmers_신규아이디추천 {
	

	//static String newId;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/programmers_input/programmers_input_신규아이디추천.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String newId = br.readLine();
		
		newId = new kakaoId(newId)
				.replaceToLowerCase()
				.filter()
				.toSingleDot()
				.noStartEndDot()
				.noBlank()
				.noGreaterThan16()
				.noLessThan2()
				.getResult();
		
		System.out.println(newId);
	}
	
	private static class kakaoId{
		private String s;
		
		public kakaoId(String s) {
			this.s = s;
		}
		
		private kakaoId replaceToLowerCase() {
			s = s.toLowerCase();
			return this;
		}
		
		private kakaoId filter() {
			s = s.replaceAll("[^a-z0-9._-]", "");
			return this;
		}
		
		private kakaoId toSingleDot() {
			s = s.replaceAll("[.]{2,}", ".");
			return this;
		}
		
		private kakaoId noStartEndDot() {
			s = s.replaceAll("^[.]|[.]$", "");
			return this;
		}
		
		private kakaoId noBlank() {
			s = s.isEmpty() ? "a":s;
			return this;
		}
		
		private kakaoId noGreaterThan16() {
			if(s.length() >= 16) {
				s = s.substring(0,15);
			}
			s = s.replaceAll("[.]$", "");
			return this;
		}
		
		private kakaoId noLessThan2() {
			StringBuilder sb = new StringBuilder(s);
			while(sb.length() <= 2) {
				sb.append(sb.charAt(sb.length()-1));
			}
			s = sb.toString();
			return this;
		}
		
		private String getResult() {
			return s;
		}
		
	}
	
	

	

}

