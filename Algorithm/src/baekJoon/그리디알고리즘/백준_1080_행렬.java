package baekJoon.그리디알고리즘;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Scanner;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.*;
import java.util.*;

public class 백준_1080_행렬 {
	
	
	public static int N,M, answer;
	public static boolean[][] A, B;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1080.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new boolean[N][M];
		B = new boolean[N][M];
		
		for(int i = 0; i < N ; i ++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < M; j ++) {
				char tmpChar = tmp.charAt(j);
				if(tmpChar == '1') {
					A[i][j] = false;
				}else {
					A[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i < N ; i ++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < M; j ++) {
				char tmpChar = tmp.charAt(j);
				if(tmpChar == '1') {
					B[i][j] = false;
				}else {
					B[i][j] = true;
				}
			}
		}
		
		int lastX = 0;
		int lastY = 0;
		
		if(N < 3 || M < 3) {
			if(equalCheck(0,0)) {
				System.out.println(0);
			}else {
				System.out.println(-1);
			}
			return;
		}
		
		for(int i = 0 ; i <= N-3 ; i ++) {
			for(int j = 0 ; j <= M-3 ; j ++) {
				lastX = i;
				lastY = j;
				if(A[i][j] != B[i][j]) {
					answer++;
					reverse(i,j);
				}
			}
		}
		
		if(equalCheck(lastX, lastY)) {
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}
		
	}

	private static Boolean equalCheck(int lastX, int lastY) {

		for(int i = 0 ; i < N; i ++) {
			for(int j =0  ; j < M ; j ++) {
				if(A[i][j] != B[i][j]) {
					return false;
				}
			}
		}
		return true;
		
	}

	private static void reverse(int startX, int startY) {
		for(int i = startX ; i < startX+3; i ++) {
			for(int j = startY ; j < startY+3; j++) {
				A[i][j] = !A[i][j];
			}
		}
		
	}

}

