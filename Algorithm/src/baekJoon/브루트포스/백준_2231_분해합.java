package baekJoon.브루트포스;

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

public class 백준_2231_분해합 {
	

	static int N ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_2231.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int M=1;
		while(true) {
			if(M >= N) {
				M=0;
				break;
			}
			int tmp = M;
			int sum = 0;
			sum += tmp;
			while(true) {
				if(tmp/10 == 0) {
					sum += tmp % 10;
					break;
				}
				sum += tmp%10;
				tmp /= 10;
			}
			if(sum == N) {
				break;
			}
			M++;
		}
		
		System.out.println(M);
	}

}

