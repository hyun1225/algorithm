package baekJoon.문자열;

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

public class 백준_1316_그룹단어체크_ver2 {
	

	public static int N;
	public static int ans;
	public static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_1316.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = 0;
		
		for(int i = 0 ; i < N ; i ++) {
			String str = br.readLine();
			if(group(str)) ans ++;
		}
		System.out.println(ans);
	}

	private static boolean group(String str) {
		
		check = new boolean[26];
		char prev = str.charAt(0);
		check[prev-'a'] = true;
		
		for(int j = 1 ; j < str.length(); j ++) {
			char now = str.charAt(j);
			if(prev != now) {
				if(!check[now-'a']) {
					check[now-'a'] = true;
					prev = now;
				}else {
					return false;
				}
			}
		}
		return true;
	}

}

