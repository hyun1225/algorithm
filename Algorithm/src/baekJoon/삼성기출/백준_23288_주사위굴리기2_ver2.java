package baekJoon.삼성기출;

import java.util.ArrayList;
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

public class 백준_23288_주사위굴리기2_ver2 {
	
	static int N,M,K, score, cnt;
	static int[][] map, scoreMap;
	static boolean[][] visit;
	static Dice dice;
	static int[] dx = new int[]{-1,0,1,0};
	static int[] dy = new int[]{0,1,0,-1};
 
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_23288.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		scoreMap = new int[N][M];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice = new Dice(0, 0, 1, new int[] {2,1,5,6,4,3});
		//dice = new Dice(0, 1, 2, new int[] {2,4,5,3,6,1});
		
		List<Integer> list = new ArrayList<>();
		
		int num = 1;
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
				if(scoreMap[i][j] == 0) {
					int cnt = scoreCheck(i,j,num);
					list.add(cnt);
					num++;
				}
			}
		}
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
				scoreMap[i][j] =  list.get(scoreMap[i][j] - 1) * map[i][j]; 
			}
		}
		
		for(int i = 0 ; i < K ; i ++) {
			play();
		}
		
		System.out.println(score);
		
		
	}
	
	private static int scoreCheck(int x, int y, int num) {
		int cnt = 1;
		scoreMap[x][y] = num ;
		
		for(int d = 0 ; d < 4 ; d ++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(!inArea(nx, ny)) continue;
			if(scoreMap[nx][ny] != 0) continue;
			if(map[x][y] != map[nx][ny]) continue;
			
			cnt += scoreCheck(nx, ny, num);
		}
		
		return cnt;
	}

	private static void play() {
		move();
		getScore();
		changeDir();
	}
	
	private static void changeDir() {
		int bottom = dice.diceNum[3];
		int mapNum = map[dice.x][dice.y];
		
		if(bottom > mapNum) {
			if(dice.dir == 3) {
				dice.dir = 0;
			}else {
				dice.dir ++;
			}
		}else if(bottom < mapNum) {
			if(dice.dir == 0) {
				dice.dir = 3;
			}else {
				dice.dir --;
			}
		}
			
	}

	private static void getScore() {
		score += scoreMap[dice.x][dice.y];
	}

	private static void dfs(int x, int y, int num) {
		visit[x][y] = true;
		
		for(int d = 0 ; d < 4 ; d ++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(!inArea(nx, ny)) continue;
			if(visit[nx][ny]) continue;
			if(map[nx][ny] != num) continue;
			cnt ++;
			dfs(nx, ny, num);
		}
		
	}

	private static void move() {
		int nx = dice.x + dx[dice.dir];
		int ny = dice.y + dy[dice.dir];
		
		if(!inArea(nx ,ny)) {
			// 영역 넘어갈시 이동방향 반대로 변경 
			if(dice.dir < 2) {
				dice.dir = dice.dir + 2 ;
			}else {
				dice.dir = dice.dir - 2 ;
			}
			
			nx = dice.x + dx[dice.dir];
			ny = dice.y + dy[dice.dir];
		}
		
		dice.x = nx ;
		dice.y = ny ;
		
		changeDiceNum();
		
	}

	private static void changeDiceNum() {
		int temp = 0;
		
		
		switch (dice.dir) {
		
			case 0:
				/*
				temp = dice.diceNum[1];
				dice.diceNum[1] = dice.diceNum[0];
				dice.diceNum[0] = dice.diceNum[3];	
				dice.diceNum[3] = dice.diceNum[2];
				dice.diceNum[2] = temp;
				break;
				*/
				
				temp = dice.diceNum[1];
				dice.diceNum[1] = dice.diceNum[2];
				dice.diceNum[2] = dice.diceNum[3];
				dice.diceNum[3] = dice.diceNum[0];
				dice.diceNum[0] = temp;
				break;
			
			case 1:
				temp = dice.diceNum[1];
				dice.diceNum[1] = dice.diceNum[4];
				dice.diceNum[4] = dice.diceNum[3];
				dice.diceNum[3] = dice.diceNum[5];
				dice.diceNum[5] = temp;
				break;
			
			case 2:
				/*
				temp = dice.diceNum[1];
				dice.diceNum[1] = dice.diceNum[2];
				dice.diceNum[2] = dice.diceNum[3];
				dice.diceNum[3] = dice.diceNum[0];
				dice.diceNum[0] = temp;
				break;
				*/
				
				temp = dice.diceNum[1];
				dice.diceNum[1] = dice.diceNum[0];
				dice.diceNum[0] = dice.diceNum[3];	
				dice.diceNum[3] = dice.diceNum[2];
				dice.diceNum[2] = temp;
				break;
				
			
			case 3:
				temp = dice.diceNum[1];
				dice.diceNum[1] = dice.diceNum[5];
				dice.diceNum[5] = dice.diceNum[3];
				dice.diceNum[3] = dice.diceNum[4];
				dice.diceNum[4] = temp;
				break;
		}
		
	}

	private static boolean inArea(int x, int y) {
		if( x < 0 || x >= N || y < 0 || y >= M ) {
			return false;
		}else {
			return true;
		}
	}

	static class Dice{
		int x;
		int y;
		int dir;
		int[] diceNum;
		
		public Dice(int x, int y, int dir, int[] diceNum) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.diceNum = diceNum;
		}
	}

}

