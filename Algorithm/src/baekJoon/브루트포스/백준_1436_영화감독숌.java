package baekJoon.브루트포스;

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

public class 백준_1436_영화감독숌 {
	
	public static int N;
	public static int seriesNum = 666;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1436.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		String seriesNumStr = "";
	
		while(true) {
			
			seriesNumStr = seriesNum + "";
			
			if(seriesNumStr.indexOf("666") > -1) {
				N--;
				if(N == 0) {
					break;
				}
			}
			seriesNum ++;
		}
		
		System.out.println(seriesNum);
		
		
	}

}

