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

public class 백준_2675_문자열반복 {
	

	

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_2675.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i ++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			String repeatStr = "";
			
			for(int j = 0 ; j < str.length() ; j ++) {
				char ch = str.charAt(j);
				for(int k = 0 ; k < num ; k ++) {
					repeatStr += ch;
				}
			}
			sb.append(repeatStr).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

}

