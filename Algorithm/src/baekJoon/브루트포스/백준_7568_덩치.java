package baekJoon.브루트포스;

import java.util.ArrayList;

import java.util.Queue;
import java.util.Scanner;
import java.util.Scanner;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.*;
import java.util.*;


public class 백준_7568_덩치 {
	

	public static bodySize[] bs, selectBs;
	public static int N;
	public static int[] rank;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_7568.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		bs = new bodySize[N];
		selectBs = new bodySize[2];
		rank = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			bs[i] = new bodySize(weight,height,i);
		}
		
		select(0,0);
		for(int i = 0 ; i < N ; i ++) {
			sb.append(rank[i]+1).append(" ");
		}
		System.out.println(sb);
		
	}
	
	private static void select(int start, int depth) {
		if(depth == 2) {
			check();
			return;
		}
		
		for(int i = start ; i < N ; i ++) {
			selectBs[depth] = bs[i];
			select(i+1 , depth+1);
		}
		
	}

	private static void check() {
		bodySize A = selectBs[0];
		bodySize B = selectBs[1];
		if(A.weight > B.weight && A.height > B.height) {
			rank[B.order] ++ ;
		}else if(A.weight < B.weight && A.height < B.height) {
			rank[A.order] ++ ;
		}
	}

	static class bodySize{
		int weight;
		int height;
		int order;
		
		bodySize(int weight, int height, int order){
			this.weight = weight;
			this.height = height;  
			this.order = order;
		}
	}

}

