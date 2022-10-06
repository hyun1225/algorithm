package baekJoon.문자열;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
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

public class 백준_9012_괄호 {
	

	static int tc;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_9012.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
	
		for(int i = 0 ; i < tc ; i ++) {
			String ps = br.readLine();
			checkVPS(ps);
		}
		System.out.println(sb.toString());
		
	}

	private static void checkVPS(String ps) {
		
		String result = "YES";
		int cnt = 0;
		for(int i = 0 ; i < ps.length(); i ++) {
			char tmp = ps.charAt(i);
			if(tmp == '(') {
				cnt ++;
			}else {
				cnt --;
			}
			
			// '(' 가 없는데 ')' 가 나온 경우  
			if(cnt < 0) {
				result = "NO";
				break;
			}
		}
		
		// cnt > 0 면 '(' 가 안닫힌 경우
		// cnt < 0 면 '(' 가 없는데 ')' 가 나온 경우  
		if(cnt != 0) {
			result = "NO";
		}
		
		sb.append(result).append("\n");
		
	}

}

