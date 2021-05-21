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

public class 백준_1057_토너먼트 {
	

	public static int N,a,b;
	public static boolean[] people;
	public static boolean[] temp;
	public static int round=0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1057.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		people = new boolean[N];
		a = Integer.parseInt(st.nextToken())-1;
		b = Integer.parseInt(st.nextToken())-1;
		people[a] = true;
		people[b] = true;
		
		while(true) {
			round++;
			if( (a/2) == (b/2)) {
				break;
			}else {
				a = a/2;
				b = b/2;
			}
		}
		System.out.println(round);
	}

}

