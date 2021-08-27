package baekJoon.그리디알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

public class 백준_1946_신입사원 {
	

	static int testCase,N;
	static List<score> list ;
	static int answer = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_1946.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < testCase ; i ++) {
			N = Integer.parseInt(br.readLine());
			list  = new ArrayList<>();
			answer = 1;
			
			for(int j = 0 ; j < N ; j ++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new score(a,b));
			}
			Collections.sort(list);
			
			count();
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void count() {
		int pivot = list.get(0).meetingScore;
		for(int i = 1 ; i < list.size() ; i ++) {
			score select = list.get(i);
			
			if(select.meetingScore < pivot) {
				answer ++;
				pivot = select.meetingScore;
			}
		}
	}

	static class score implements Comparable<score>{
		int paperScore;
		int meetingScore;
		
		public score(int paperScore, int meetingScore) {
			this.paperScore = paperScore;
			this.meetingScore = meetingScore;
		}

		@Override
		public int compareTo(score o) {
			// TODO Auto-generated method stub
			if(this.paperScore > o.paperScore) {
				return 1;
			}
			return -1;
		}
	}

}

