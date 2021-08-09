package baekJoon.정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

public class 백준_10814_나이순정렬 {
	

	static int N ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_10814.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		List<personInfo> personList = new ArrayList<>();
		
		for(int i = 0 ;  i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int order = i;
			personInfo p = new personInfo(age,name,order);
			personList.add(p);
		}
		
		Collections.sort(personList);
		
		for(int i = 0 ; i < N ; i ++) {
			sb.append(personList.get(i).age+" ").append(personList.get(i).name+"\n");
		}
		
		System.out.println(sb);
		
	}
	
	static class personInfo implements Comparable<personInfo>{
		int age;
		String name;
		int order;
		
		personInfo(int age, String name, int order) {
			this.age = age;
			this.name = name;
			this.order = order;
		}

		@Override
		public int compareTo(personInfo o) {
			// TODO Auto-generated method stub
			if(this.age > o.age) {
				return 1;
			}else if( this.age == o.age) {
				if(this.order > o.order) {
					return 1;
				}else {
					return -1;
				}
			}else {
				return -1;
			}
		}
	}

}

