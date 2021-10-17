package baekJoon.문자열;

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

public class 백준_1152_단어의개수_ver2 {
	

	public static String str;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1152.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		str = str.trim();
		
		if(str.length() == 0) {
			System.out.println(0);
		}else {
			System.out.println(str.split(" ").length);
		}
		
	}

}

