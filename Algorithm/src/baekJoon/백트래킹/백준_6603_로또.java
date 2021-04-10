package baekJoon.백트래킹;


import java.util.*;
import java.io.*;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제


public class 백준_6603_로또 {
	

	public static int[] nums;
	public static boolean[] visit;
	//public static int[] select;
	public static int k;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_6603.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			nums = new int[k];
			visit = new boolean[k];
		//	select = new int[6];
			for(int i = 0 ; i < k ; i ++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			lotto(0,0);
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

	private static void lotto(int cnt, int start) {
		
		if(cnt == 6) {
			String s = "";
			for(int i = 0 ; i < k ; i ++) {
				if(visit[i]) {
					s = s + nums[i] + " ";
				}
				//s = s + select[i] + " ";
			}
			sb.append(s);
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < k; i ++) {
			//if(!visit[i]) {
				visit[i] = true;
			//	select[cnt] = nums[i];
				lotto(cnt+1, i+1);
				visit[i] = false;
			//}
		}
		
	}

}

