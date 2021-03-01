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

public class 백준_1541_잃어버린괄호 {
	

	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1541.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] subtraction = br.readLine().split("\\-");
		int answer = 0 ;
		
		for(int i = 0 ; i < subtraction.length; i ++) {
			
			int tmp = 0 ;
			String[] addition = subtraction[i].split("\\+");
			for(int j = 0 ; j < addition.length; j ++) {
				tmp +=  Integer.parseInt(addition[j])  ;
			}
			if(i==0) {
				answer = tmp;
			}else {
				answer -= tmp;
			}
		}
		
		System.out.println(answer);
		
	}

}

