package baekJoon.삼성기출;

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

public class 백준_14503_로봇청소기 {
	
	static int N,M;
	static int[][] map;
	static int answer=0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static RobotInfo robot;
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_14503.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		robot = new RobotInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean();
		System.out.println(answer);
		
	}
	
	static void clean() {
		answer++;
		map[robot.x][robot.y] = 2;
		
		while(true) {
			
			int turnCnt = 1;
			
			for(; turnCnt <= 4 ;turnCnt ++) {
				if(leftCheck()) {
					//회전  
					robot.dir = findLeft(); 
					//한칸 전진 
					robot.x = robot.x + dx[robot.dir];
					robot.y = robot.y + dy[robot.dir];
					//청소칸 ++,map = 2 로 수정 
					answer++;
					map[robot.x][robot.y] = 2;
					break;
				}else {
					//회전 
					robot.dir = findLeft();
				}
			}
			
			if(turnCnt > 4) {
				if(!goBack()) {
					break;
				}
			}
		}
	}
	
	private static boolean leftCheck() {
		int left = findLeft();
		
		int leftX = robot.x + dx[left];
		int leftY = robot.y + dy[left];
		
		if(map[leftX][leftY] != 0) {
			return false;
		}else {
			return true;
		}
	}

	private static int findLeft() {
		if(robot.dir == 0) {
			return 3;
		}else {
			return robot.dir - 1;
		}
	}

	private static boolean goBack() {
		int back = findBack();
		int backX = robot.x + dx[back];
		int backY = robot.y + dy[back];
		
		if(map[backX][backY] == 1) {
			return false;
		}else {
			robot.x = robot.x + dx[back];
			robot.y = robot.y + dy[back];
			return true;
		}
	}

	private static int findBack() {
		int back = 0;
		
		if(robot.dir == 0 || robot.dir == 1) {
			 back = robot.dir + 2;
		}else {
			back = robot.dir - 2;
		}
		return back;
	}

	static class RobotInfo{
		int x;
		int y;
		int dir;
		
		public RobotInfo(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

}

