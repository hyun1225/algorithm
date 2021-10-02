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

public class 백준_14499_주사위굴리기 {
	
	
	static int N,M,K;
	static int[][] map;
	static int[] dice;
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	static StringBuilder sb;
	static Pos position;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_14499.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		position = new Pos(x,y);
		K = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice = new int[7];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < K ; i ++) {
			int dir = Integer.parseInt(st.nextToken());
			move(dir);
		}
		
		System.out.println(sb);
	}
	
	public static void move(int dir) {
		// 1.주사위의 현재 위치 변경(지도 벗어날 경우 return)
		int nx = position.x + dx[dir];
		int ny = position.y + dy[dir];
		
		if(!areaCheck(nx,ny)) {
			return;
		}
		
		position.x = nx;
		position.y = ny;
		
		// 2.주사위 돌린 후 주사위의 값 변경  
		int[] temp = dice.clone();
		if(dir == 1) {
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[6] = temp[3];
			dice[4] = temp[6];
		}else if(dir == 2) {
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[6] = temp[4];
			dice[4] = temp[1];
		}else if(dir == 3) {
			dice[1] = temp[2];
			dice[5] = temp[1];
			dice[6] = temp[5];
			dice[2] = temp[6];
		}else if(dir == 4) {
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[6] = temp[2];
			dice[5] = temp[6];
		}
		
		// 3.지도의 값에 따라 주사위 바닥면과 지도값 변경 
		if(map[position.x][position.y] == 0) {
			map[position.x][position.y] = dice[6] ;
		}else {
			dice[6] = map[position.x][position.y] ;
			map[position.x][position.y] = 0 ;
		}
		
		// 4.윗면의 값 sb에 저장 
		sb.append(dice[1]).append("\n");
	}
	
	private static boolean areaCheck(int nx, int ny) {
		if(nx >= N || nx < 0 || ny >= M || ny < 0) {
			return false;
		}
		return true;
	}

	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

