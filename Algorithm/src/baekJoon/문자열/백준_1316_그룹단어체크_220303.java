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

public class 백준_1316_그룹단어체크_220303 {
	
	static int N;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_1316.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		String str ;
		int answer = 0 ;
		
		for(int i = 0 ; i < N ; i ++) {
			str = br.readLine();
			answer += solution(str);
		}
		
		System.out.println(answer);
		
	}


	private static int solution(String str) {
		// TODO Auto-generated method stub
		boolean[] alph = new boolean[26];
		
		for(int i = 0 ; i < str.length(); i ++) {
			int num = str.charAt(i) - 'a';
			if( alph[num] ) {
				if(str.charAt(i) != str.charAt(i-1)) {
					return 0;
				}
			}else {
				alph[num] = true;
			}
		}
		
		return 1;
	}

}

