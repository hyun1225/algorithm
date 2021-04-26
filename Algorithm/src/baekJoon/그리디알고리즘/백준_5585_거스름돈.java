package baekJoon.그리디알고리즘;

import java.util.ArrayList;
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

public class 백준_5585_거스름돈 {
	

	public static int money;
	public static int[] coin = {500, 100, 50, 10 ,5, 1};
	public static int cnt = 0;
	public static int min = Integer.MAX_VALUE;
	public static boolean flag = false;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_5585.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		money = 1000 - Integer.parseInt(br.readLine());
		
		greedy();
		System.out.println(min);
		//System.out.println("총 방법수 : " + totalCnt);
		
	}

	private static void greedy() {
		
		for(int i = 0 ; i < 6 ; i ++) {
			money -= coin[i];
			cnt++;
			if(money == 0) {
				min = Math.min(min, cnt);
				flag = true; // 그리디 알고리즘
				//money+=coin[i];
				return;
			}else if(money > 0) {
				greedy();
				if(flag) return; // 그리디 알고리즘
				cnt--;
			}else {
				cnt--;
				money+=coin[i];
			}
		}
		
	}

}

