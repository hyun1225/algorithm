package baekJoon.그리디알고리즘;

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

public class 백준_1931_회의실배정 {
	

	static int N;
	static Meeting[] arr;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_1931.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		arr = new Meeting[N];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i] = new Meeting(start,end);
		}
		
		Arrays.sort(arr);
		
		int cnt = 0 ;
		int endTime = 0;
		
		for(int i = 0 ; i < N ; i ++) {
			if(endTime <= arr[i].start) {
				endTime = arr[i].end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}
	
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		@Override
		public int compareTo(Meeting o) {
			
			if(this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}

