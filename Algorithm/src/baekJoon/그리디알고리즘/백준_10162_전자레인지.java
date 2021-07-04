package baekJoon.그리디알고리즘;

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

public class 백준_10162_전자레인지 {
	

	public static int[]	microwave;
	public static int T;
	public static int A,B,C;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_10162.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		microwave = new int[301];
		T = Integer.parseInt(st.nextToken());
		
		/*
		if(T>=300) {
			A = T/300;
			T-=300*A;
		}
		if(T>=60) {
			B=T/60;
			T-=60*B;
		}
		if(T%10!=0) {
			System.out.println(-1);
			System.exit(0);
		}else {
			C = T/10;
		}
		System.out.println(A + " " + B + " " + C + " ");
		*/
		
		
		while(true) {
			if(T==0) break;
			if((T>=300) && (T%300 == 0)) {
				microwave[300] += T/300;
				break;
			}else if((T>=60) && (T%60 == 0)) {
				microwave[60] += T/60;
				break;
			}
			if(T-10 < 0) {
				System.out.println(-1);
				return;
			}
			T-=10;
			microwave[10]++;
		}
		
		System.out.print(microwave[300] + " ");
		System.out.print(microwave[60] + " ");
		System.out.print(microwave[10]);
		
		
		
	}

}

