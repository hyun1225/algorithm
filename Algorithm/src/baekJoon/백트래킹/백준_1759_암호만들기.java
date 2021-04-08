package baekJoon.백트래킹;

import java.util.ArrayList;
import java.util.Arrays;
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

public class 백준_1759_암호만들기 {
	
	public static int L,C, mo, ja;
	public static char[] arr, tmp;
	public static boolean[] visit;
	public static StringBuilder sb;
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1759.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		
		arr = new char[C];
		String[] tmpStr = br.readLine().split(" ");
		for(int i = 0 ; i < C; i ++) {
			arr[i] = tmpStr[i].charAt(0);
		}
		visit = new boolean[C];
		tmp = new char[L];
		
		Arrays.sort(arr);
		
		password(0, 0);
		
		System.out.println(sb);
	}


	private static void password(int start, int cnt) {
		
		if(cnt == L) {
			if(mo >= 1 && ja >= 2) {
				String str = new String(tmp);
				sb.append(str);
				sb.append("\n");
			}
			return;
		}
		
		for(int i = start; i < C; i ++) {
			if(!visit[i]) {
				visit[i] = true;
				tmp[cnt] = arr[i];
				boolean moFlag = false;
				if(moCheck(tmp[cnt])) {
					mo++;
					moFlag = true;
				}else {
					ja++;
				}
				password(i+1, cnt+1);
				visit[i] = false;
				if(moFlag) {
					mo--;
				}else {
					ja--;
				}
			}
		}
		
	}


	private static boolean moCheck(char str) {
		if(str == 'a' || str == 'e' ||str == 'i' ||str == 'o' ||str == 'u') {
			return true;
		}else {
			return false;
		}
	}
}

