package baekJoon.시뮬레이션;

import java.util.*;
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

public class 백준_1966_프린터큐 {
	
	public static ArrayList<int[]> list;
	public static int answer;
	public static int N,M;
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1966.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer = 0;
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i ++) {
				list.add(new int[] {i,Integer.parseInt(st.nextToken())});
			}
			
			while(!list.isEmpty()) {
				int[] first = list.get(0);
				boolean flag = false;
				for(int i = 1 ; i < list.size(); i ++) {
					int[] tmp = list.get(i);
					if(first[1] < tmp[1]) {
						list.remove(0);
						list.add(first);
						flag = true;
						break;
					}
				}
				if(!flag) {
					answer++;
					if(first[0] == M) {
						System.out.println(answer);
						break;
					}
					list.remove(0);
				}
			}
			
				
		}
		
	}

}

