package baekJoon;

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

public class 백준_2577_숫자의개수 {
	
	public static int[] nums = new int[10];
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_2577.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = 1;
			N *= Integer.parseInt(br.readLine());
			N *= Integer.parseInt(br.readLine());
			N *= Integer.parseInt(br.readLine());
			String str = N+"";
			for(int i = 0 ; i < str.length(); i++) {
				nums[str.charAt(i)-'0'] ++;
			}
		
			for(int i = 0 ; i < nums.length; i ++) {
				System.out.println(nums[i]);
			}
		
	}

}

