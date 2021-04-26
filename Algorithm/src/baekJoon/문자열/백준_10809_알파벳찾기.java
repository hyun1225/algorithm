package baekJoon.문자열;

import java.util.ArrayList;
import java.util.Arrays;
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

public class 백준_10809_알파벳찾기 {
	
	
	public static String str;
	public static int[] alpha;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_10809.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		alpha = new int[26];
		Arrays.fill(alpha, -1);
		
		for(int i = 0 ; i < str.length();i++) {
			if(alpha[str.charAt(i)-97] == -1) {
				alpha[str.charAt(i)-97] = i;
			}
		}
		
		for(int i = 0 ; i < 26; i ++) {
			System.out.print(alpha[i]+" ");
		}

		
		
	}

}

