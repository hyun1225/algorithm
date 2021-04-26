package baekJoon.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

public class 백준_1026_보물 {
	
	public static int N = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public static int[] a ,b;
	public static int[] tmpA;
	public static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_1026.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  ;
		
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		b = new int[N];
		visit = new boolean[N];
		tmpA = new int[N];
		ArrayList<Integer> AarrayList = new ArrayList<>();
		ArrayList<Integer> BarrayList = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int j = 0 ; j < N ; j++) {
			a[j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int j = 0 ; j < N ; j++) {
			b[j] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i = 0 ; i < N ; i ++) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			int minIndex = 0, maxIndex=0;
			for(int j = 0 ; j < N; j ++) {
				if(min > a[j]) {
					min = a[j];
					minIndex = j;
				}
				if(max < b[j]) {
					max = b[j];
					maxIndex = j;
				}
			}
			sum += min * max ;
			a[minIndex] = Integer.MAX_VALUE;
			b[maxIndex] = Integer.MIN_VALUE;
		}
		System.out.println(sum);
		
		/* 방법1
		st = new StringTokenizer(br.readLine());
		for(int j = 0 ; j < N ; j++) {
			a[j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int j = 0 ; j < N ; j++) {
			b[j] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int sum = 0;
		for(int i = 0 ; i < N ; i ++) {
			sum += a[i] * b[N-1-i];
		}
		System.out.println(sum);
		 */
		
		/* 방법2
		 *순열로 전체탐색시 시간초
		permu(0);
		System.out.println(min);
		*/
		
		/* 빙법3
		st = new StringTokenizer(br.readLine());
		for(int j = 0 ; j < N ; j++) {
			AarrayList.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int j = 0 ; j < N ; j++) {
			BarrayList.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(AarrayList);
		Collections.sort(BarrayList);
		Collections.reverse(BarrayList);
		int sum = 0;
		for(int i = 0 ; i < N ; i ++) {
			sum += AarrayList.get(i) * BarrayList.get(i);
		}
		System.out.println(sum);
		 */
	}

	private static void permu(int num) {
		
		if(num == N) {
			min = Math.min(min, calc());
			return;
		}
		
		for(int i = 0 ; i < N; i ++ ) {
			if(!visit[i]) {
				visit[i] = true;
				tmpA[i] = a[num];
				permu(num+1);
				visit[i] = false;
			}
		}
		
	}

	private static int calc() {
		int sum = 0;
		
		for(int i = 0 ; i < N ; i ++) {
			sum+= tmpA[i]*b[i];
		}
		return sum;
	}

}

