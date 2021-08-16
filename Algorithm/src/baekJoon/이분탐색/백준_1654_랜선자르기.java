package baekJoon.이분탐색;

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

public class 백준_1654_랜선자르기 {
	

	static int N,K;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1654.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" "); 
		
		K = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		
		int[] arr = new int[K];
		
		for(int i = 0 ; i < K ; i ++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long start = 1;
		long end = arr[K-1];
		long mid = 0;
		
		while(start <= end) {
			long sum = 0;
			mid = (start + end) / 2; 
			
			for(int i = 0 ; i < K ; i ++) {
				sum += arr[i]/mid;
			}
			
			if(sum >= N) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		System.out.println(end);
		
	}

}

