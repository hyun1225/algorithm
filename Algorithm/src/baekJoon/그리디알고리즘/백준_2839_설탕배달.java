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

public class 백준_2839_설탕배달 {
	
	public static int answer;
	public static int sugar;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_2839.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sugar = Integer.parseInt(br.readLine());
		
		while(true) {
			if(sugar % 5 == 0) {
				answer += sugar/5;
				break;
			}
			sugar-=3;
			answer++;
			if(sugar < 0) {
				answer = -1;
				break;
			}
		}
		
		System.out.println(answer);
		
		
	}

}

