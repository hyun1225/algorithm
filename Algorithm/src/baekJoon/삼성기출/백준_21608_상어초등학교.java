package baekJoon.삼성기출;

import java.util.ArrayList;
import java.util.*;
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

public class 백준_21608_상어초등학교 {
	
	public static int N;
	public static List<Student> studentList;
	public static int[][] map;
	public static selectSeat seatInfo;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_21608.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		studentList = new ArrayList<>();
		map = new int[N][N];
		
		for(int i = 0 ; i < Math.pow(N, 2); i ++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] likeStudent = new int[4];
			for(int j = 0 ; j < 4 ; j ++) {
				likeStudent[j] = Integer.parseInt(st.nextToken());
			}
			studentList.add(new Student(num, likeStudent, 0));
		}
		
		for(int i = 0 ; i < studentList.size(); i ++) {
			check(i);
		}
		
		
		
		System.out.println(satisfactionCheck());
	}
	
	private static int satisfactionCheck() {
		
		
		int returnValue = 0;
		
		for(int i = 0 ; i < studentList.size(); i ++) {
			Student s = studentList.get(i);
			int cnt = 0 ;
			
			for(int d = 0 ; d < 4 ; d++) {
				int nx = s.row + dx[d];
				int ny = s.col + dy[d];
				if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
				for(int k = 0 ; k < s.likeStudent.length; k ++) {
					if(s.likeStudent[k] == map[nx][ny]) {
						cnt ++ ;
						break;
					}
				}
			}
			returnValue += score(cnt);
		}
		return returnValue;
		
		
	}

	private static int score(int cnt) {
		int value = 0;
		
		if(cnt == 0) value = 0;
		else if(cnt == 1) value = 1;
		else if(cnt == 2) value = 10;
		else if(cnt == 3) value = 100;
		else value = 1000;
		
		return value;
	}

	private static void check(int index) {
		Student s = studentList.get(index);
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N ; j ++) {
				if(map[i][j] == 0) {
					adjustCheck(i,j,s);
				}
			}
		}
		
		map[seatInfo.row][seatInfo.col] = s.num;
		s.row = seatInfo.row;
		s.col = seatInfo.col;
		seatInfo = null;
		
	}

	private static void adjustCheck(int x, int y, Student s) {
		
		int likeCnt = 0;
		int emptyCnt = 0;
		
		for(int d = 0 ; d < 4 ; d ++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
			if(map[nx][ny] == 0) {
				emptyCnt ++;
			}else {
				for(int i = 0 ; i < s.likeStudent.length; i ++) {
					if(map[nx][ny] == s.likeStudent[i]) {
						likeCnt ++;
						break;
					}
				}
			}
		}
		
		if(seatInfo == null) {
			seatInfo = new selectSeat(likeCnt, emptyCnt, x, y);
		}else {
			if(seatInfo.likeCnt < likeCnt) {
				seatInfo = new selectSeat(likeCnt, emptyCnt, x, y);
			}else if(seatInfo.likeCnt == likeCnt) {
				if(seatInfo.emptyCnt < emptyCnt) {
					seatInfo = new selectSeat(likeCnt, emptyCnt, x, y);
				}else if(seatInfo.emptyCnt == emptyCnt) {
					if(seatInfo.row > x) {
						seatInfo = new selectSeat(likeCnt, emptyCnt, x, y);
					}else if(seatInfo.row == x) {
						if(seatInfo.col > y) {
							seatInfo = new selectSeat(likeCnt, emptyCnt, x, y);
						}
					}
				}
			}
		}
		
	}

	static class Student{
		int num;
		int[] likeStudent;
		int likeCnt;
		int row;
		int col;
		
		Student(int num, int[] likeStudent, int likeCnt){
			this.num = num;
			this.likeStudent = likeStudent;
			this.likeCnt = likeCnt;
		}
	}
	
	static class selectSeat{
		int likeCnt;
		int emptyCnt;
		int row;
		int col;
		
		selectSeat(int likeCnt, int emptyCnt, int row, int col){
			this.likeCnt = likeCnt;
			this.emptyCnt = emptyCnt;
			this.row = row;
			this.col = col;
		}
	}

}

