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

public class 백준_14500_테트로미노_dfs {
	

	static int N,M;
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_14500.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
				visit[i][j] = true;
				dfs(i,j,map[i][j],1);
				visit[i][j] = false;
				exeption(i,j);
			}
		}
		
		System.out.println(max);
		
	}

	private static void exeption(int i, int j) {
		
		int min = Integer.MAX_VALUE;
		
		int cnt = 0;
		int sum = map[i][j];
		for(int d = 0 ; d < 4 ; d ++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(isArea(nx,ny)) {
				cnt ++;
				min = Math.min(map[nx][ny], min);
				sum += map[nx][ny];
			}
		}
		
		if(cnt >= 3) {
			if(cnt == 4) {
				sum -= min;
			}
			max = Math.max(sum, max);
		}
		
	}

	private static void dfs(int i, int j, int sum, int depth) {
		if(depth == 4) {
			max = Math.max(sum, max);
			return;
		}
		
		for(int d = 0 ; d < 4 ; d ++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(!isArea(nx,ny)) {
				continue;
			}
			
			if(visit[nx][ny]) {
				continue;
			}
			
			visit[nx][ny] = true;
			dfs(nx,ny,sum+map[nx][ny],depth+1);
			visit[nx][ny] = false;
			
		}
		
	}

	private static boolean isArea(int nx, int ny) {
		if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
			return true;
		}
		return false;
	}

}

