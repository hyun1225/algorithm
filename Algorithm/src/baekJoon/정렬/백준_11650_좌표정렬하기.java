package baekJoon.정렬;

import java.util.*;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.*;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Scanner;

public class 백준_11650_좌표정렬하기 {
	

	public static List<point> pointList;
	public static int N ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_11650.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		pointList = new ArrayList<>();
		
		Comparator<point> myComparator2 = new Comparator<>() {

			public int compare(point p1, point p2) {
				if(p1.x > p2.x) {
					return 1;
				}else if(p1.x == p2.x) {
					if(p1.y > p2.y) {
						return 1;
					}
				}
				return -1;
			}
			
		};
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pointList.add(new point(x,y));
		}
		
		//myComparator comparator = new myComparator();
		//Collections.sort(pointList,myComparator2);
		Collections.sort(pointList);
		
		for(int i = 0 ; i < pointList.size(); i ++) {
			point p = pointList.get(i);
			System.out.println(p.x + " " + p.y);
		}
		
		
		
		 
		
	}
	
	static class point implements Comparable<point>{
		int x;
		int y;
		
		point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(point p) {
			if(this.x > p.x) {
				return 1;
			}else if(this.x == p.x) {
				if(this.y > p.y) {
					return 1;
				}
			}
			return -1;
		}
	}
	
	static class myComparator implements Comparator<point>{
		public int compare(point p1, point p2) {
			if(p1.x > p2.x) {
				return 1;
			}else if(p1.x == p2.x) {
				if(p1.y > p2.y) {
					return 1;
				}
			}
			return -1;
		}
	}

}

