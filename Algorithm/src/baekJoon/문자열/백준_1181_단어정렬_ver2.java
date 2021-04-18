package baekJoon.문자열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
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

public class 백준_1181_단어정렬_ver2 {
	

	public static int n;
	public static List<String> str  = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_1181.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		/*
		for(int i = 0 ; i < n ; i ++) {
			String temp = br.readLine();
			if(!str.contains(temp)) {
				str.add(temp);
			}
		}
		*/
		HashSet<String> set = new HashSet<>();
		for(int i = 0 ; i < n ; i ++) {
			set.add(br.readLine());
		}
		List<String> str = new ArrayList<>(set);
		
		Comparator<String> hjComparator = new Comparator<String>() {
			public int compare(String x, String y) {
				if(x.length() > y.length()) {
					return 1;
				}else if(x.length() == y.length()) {
					return x.compareTo(y);
				}else {
					return -1;
				}
			}
		};
		
		Collections.sort(str, hjComparator);
		for(int i = 0 ; i < str.size() ; i ++) {
			System.out.println(str.get(i));
		}
		
	}

}

