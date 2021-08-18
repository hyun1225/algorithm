package baekJoon.이분탐색;

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

public class 백준_10816_숫자카드2 {
	

	static int N,M,cnt;
	static int[] arr, numsB, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_10816.txt"));

	Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
		Arrays.sort(arr);	// 이분 탐색을 하기 위해서는 반드시 정렬되어있어야 한다.
		
		int M = in.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			int key = in.nextInt();
 
			// upperBound와 lowerBound의 차이 값을 구한다.
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		System.out.println(sb);
		
	}
	
	private static int lowerBound(int[] arr, int key) {
		int lo = 0; 
		int hi = arr.length; 
 
		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) {
 
			int mid = (lo + hi) / 2; // 중간위치를 구한다.
 
			/*
			 *  key 값이 중간 위치의 값보다 작거나 같을 경우
			 *  
			 *  (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
			 */
			if (key <= arr[mid]) {
				hi = mid;
			}
 
			else {
				lo = mid + 1;
			}
 
		}
 
		return lo;
	}
 
	private static int upperBound(int[] arr, int key) {
		int lo = 0; 
		int hi = arr.length; 
 
		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) {
 
			int mid = (lo + hi) / 2; // 중간위치를 구한다.
 
			// key값이 중간 위치의 값보다 작을 경우
			if (key < arr[mid]) {
				hi = mid;
			}
			// 중복원소의 경우 else에서 처리된다.
			else {
				lo = mid + 1;
			}
 
		}
 
		return lo;
	}
	

}

