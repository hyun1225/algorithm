package baekJoon;

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

public class 백준_1966_프린터큐_ver2 {
	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1966.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> q =new LinkedList<>();
		int[] num = new int[10];
		int N,M, count, a, Max;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			count = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			q.clear();
			Arrays.fill(num, 0);
			
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0 ; n < N ; n ++) {
				a = Integer.parseInt(st.nextToken());
				q.offer(new int[] {n,a});
				num[a]++;
			}
			
			Max = 9;
			
			loop: while(!q.isEmpty()) {
				if(num[Max] == 0) {
					Max --;
				}else {
					if(q.peek()[1] == Max) {
						count++;
						num[Max]--;
						if(q.poll()[0] == M) {
							break loop;
						}
					}else {
						q.offer(q.poll());
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
		
	}

}

