package baekJoon.조합론;

import java.util.ArrayList;
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
import java.math.BigInteger;

public class 백준_2407_조합 {
	

	static int n,m;
	static long answer;
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_2407.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		   String[] inputs = br.readLine().split(" ");

	        int n = Integer.parseInt(inputs[0]);
	        int m = Integer.parseInt(inputs[1]);

	        BigInteger n1 = BigInteger.ONE;
	        BigInteger n2 = BigInteger.ONE;

	        for (int i = 0; i < m; i++) {
	        	BigInteger b = new BigInteger(String.valueOf(n - i));
	            n1 = n1.multiply(b);
	        	b = new BigInteger(String.valueOf(i + 1));
	            n2 = n2.multiply(b);
	        }

	        BigInteger answer = n1.divide(n2);

	        System.out.println(answer);
		
	}
	
	

}

