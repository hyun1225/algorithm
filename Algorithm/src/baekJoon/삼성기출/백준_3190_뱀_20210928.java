package baekJoon.삼성기출;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.text.Position;

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

public class 백준_3190_뱀_20210928 {
	

	static int[][] map;
	static int N,K,L;
	static Queue<Position> snake = new LinkedList<>();
	static Map<Integer,String> turn = new HashMap<>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static SnakePos snakePos ;
	static int time = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_3190.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0 ; i < K ; i ++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < L ; i ++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			turn.put(time, dir);
		}
		
		snake.add(new Position(0, 0));
		snakePos = new SnakePos(0,0,1);
		map[0][0] = 2;
		
		while(true) {
			move();
			if(end()) {
				break;
			}
			bodyCheck();
		}
		
		System.out.println(time);
		
		
		
	}
	
	private static void bodyCheck() {
		if(map[snakePos.x][snakePos.y] == 1) {
			//사과가 있는 경우 
			map[snakePos.x][snakePos.y] = 2;
			snake.add(new Position(snakePos.x, snakePos.y));
		}else {
			// 사과가 없는 경우 
			map[snakePos.x][snakePos.y] = 2;
			snake.add(new Position(snakePos.x, snakePos.y));
			Position tail = snake.poll();
			map[tail.x][tail.y] = 0;
		}
		if(turn.containsKey(time)) {
			snakeTurn();
		}
	}

	private static void snakeTurn() {
		String direction = turn.get(time);
		
		if(direction.equals("L")) {
			snakePos.dir = snakePos.dir - 1;
			if(snakePos.dir < 0) {
				snakePos.dir = 3;
			}
		}else {
			snakePos.dir = snakePos.dir + 1;
			if(snakePos.dir > 3) {
				snakePos.dir = 0;
			}
		}
		
	}

	private static void move() {
		time ++;
		int nx = snakePos.x + dx[snakePos.dir];
		int ny = snakePos.y + dy[snakePos.dir];
		snakePos.x = nx ;
		snakePos.y = ny ;
	}
	
	//게임끝 여부 
	private static boolean end() {
		//범위 벗어난 경우 
		if(snakePos.x >= N || snakePos.x < 0 || snakePos.y >= N || snakePos.y < 0) {
			return true;
		}
		
		//뱀의 몸인 경우 
		if(map[snakePos.x][snakePos.y] == 2) {
			return true;
		}
		
		return false;
	}

	static class Position{
		int x ;
		int y;
		
		public Position(int x , int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class SnakePos {
		int x;
		int y;
		int dir;
		
		public SnakePos(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
	
}


