package baekJoon.조합론;

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

public class 백준_2775_부녀회장이될테야 {
	

	public static int floor, ho;
	public static int[][] apartment;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_2775.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < testCase; i ++) {
			floor = Integer.parseInt(br.readLine());
			ho = Integer.parseInt(br.readLine());
			apartment = new int[floor+1][ho+1];
			
			for(int zeroHo = 1 ; zeroHo <= ho; zeroHo++) {
				apartment[0][zeroHo] = zeroHo;
			}
			
			for(int fl = 1 ; fl <= floor ; fl ++) {
				for(int j = 1; j <= ho; j ++) {
					if(j == 1) {
						apartment[fl][j] = 1;
					}else {
						/*방법2*/
						apartment[fl][j] = apartment[fl][j-1] + apartment[fl-1][j];
						/*//방법1
						int sum = 0;
						for(int k = 1 ; k <= j ; k ++) {
							sum += apartment[fl-1][k];
						}
						apartment[fl][j] = sum;
						*/
					}
				}
			}
			
			System.out.println(apartment[floor][ho]);
			
		}
		
	}

}

