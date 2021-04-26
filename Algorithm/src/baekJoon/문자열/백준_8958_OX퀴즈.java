package baekJoon.문자열;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Scanner;
import java.io.FileInputStream;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.FileNotFoundException;

public class 백준_8958_OX퀴즈 {
	

	

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/백준input8958.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int score = 0;
			int answer = 0;
			
			String str = sc.next();
			for(int i = 0 ; i < str.length(); i ++) {
				if(str.charAt(i) == 'O') {
					score++;
					answer += score;
				}else {
					score = 0;
				}
			}
			System.out.println(answer);
				
		}
		
	}

}

