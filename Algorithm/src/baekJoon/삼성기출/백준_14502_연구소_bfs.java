package baekJoon.삼성기출;

import java.util.ArrayList;
import java.util.LinkedList;
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


public class 백준_14502_연구소_bfs {
	
	static int blank,safeArea;
	static int max = Integer.MIN_VALUE;
	static int N,M;
	static int[][] map, copyMap, spreadMap;
	static List<Position> virus ;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_14502.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		virus = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					blank++;
				}else if(map[i][j] == 2) {
					virus.add(new Position(i,j));
				}
			}
		}
		
		process();
		System.out.println(max);
		
	}
	
	private static void process() {
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(i,j,1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	private static int[][] mapCopy(int[][] copycopy) {
		int[][] tmp = new int[N][M];
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ;j ++) {
				tmp[i][j] = copycopy[i][j];
			}
		}
		
		return tmp;
	}

	private static void makeWall(int startRow, int startCol, int wallCnt) {
		
		if(wallCnt == 3) {
			virusSpread();
			return;
		}
		
		for(int i = startRow ; i < N ; i ++) {
			int l=0;
			if( i == startRow) {
				l = startCol + 1;
			}
			for(int j = l ; j < M ; j ++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(i,j,wallCnt+1);
					map[i][j] = 0;
				}
			}
		}
		
	}

	private static void virusSpread() {
		safeArea = blank-3;
		spreadMap = mapCopy(map);
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0 ; i < virus.size(); i ++) {
			q.add(new int[] {virus.get(i).x, virus.get(i).y});
		}
		
		while(!q.isEmpty()) {
			int[] v = q.poll();
			
			for(int d = 0 ; d < 4 ; d ++) {
				int nx = v[0]+dx[d];
				int ny = v[1]+dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(spreadMap[nx][ny] != 0) continue;
				spreadMap[nx][ny] = 2;
				safeArea--;
				q.add(new int[] {nx,ny});
			}
		}
		
		max = Math.max(max, safeArea);
		
	}

	private static void dfs(int x, int y) {
		
		for(int d = 0 ; d < 4 ; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(spreadMap[nx][ny] != 0) continue;
			
			spreadMap[nx][ny] = 2;
			safeArea -- ;
			dfs(nx,ny);
		}

	}

	static class Position{
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

