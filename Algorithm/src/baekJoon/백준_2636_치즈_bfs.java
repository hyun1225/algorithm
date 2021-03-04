package baekJoon;

import java.util.ArrayList;
import java.util.LinkedList;
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

public class 백준_2636_치즈_bfs {
	
	public static int N,M;
	public static int[][] map;
	public static boolean[][] visit;
	public static int cheeze = 0 , time = 0, lastCnt=0;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_2636.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheeze ++;
			}
		}
		
		while(cheeze != 0) {
			time++;
			lastCnt = cheeze;
			bfs(0,0);
		}
		System.out.println(time);
		System.out.println(lastCnt);
		
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{i,j});
		visit = new boolean[N][M];
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int d = 0 ; d < dx.length; d ++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];
				if(nx<0 || nx >=N || ny<0 || ny >=M) continue;
				if(visit[nx][ny]) continue;
				else {
					if(map[nx][ny]==1) {
						map[nx][ny] = 0 ;
						cheeze--;
					}else {
						q.offer(new int[] {nx,ny});
					}
					visit[nx][ny] = true;
				}
			}
		}
		
	}

}

