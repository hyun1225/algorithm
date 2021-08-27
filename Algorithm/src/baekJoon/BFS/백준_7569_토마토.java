package baekJoon.BFS;

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
import java.io.StreamTokenizer;

public class 백준_7569_토마토 {
	

	static int M,N,H;
	static int[][][] tomato;
	static int rawTomato;
	static Queue<int[]> q;
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	static int answer = 0;
	static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_7569.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][N][M];
		visit = new boolean[H][N][M];
		q = new LinkedList<>();
		
		for(int i = 0 ; i < H ; i ++) {
			for(int j = 0 ; j < N ; j ++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k < M ; k ++) {
					int stat = Integer.parseInt(st.nextToken());
					if(stat == 0) {
						rawTomato ++;
					}else if(stat == 1) {
						visit[i][j][k] = true;
						q.add(new int[]{i,j,k});
					}
					tomato[i][j][k] = stat;
				}
			}
		}
		
		if(rawTomato == 0) {
			answer = 0;
		}else {
			bfs();
			if(rawTomato > 0) {
				answer = -1;
			}
		}
		
		System.out.println(answer);
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Queue<int[]> copyQ = new LinkedList<>();
			
			while(!q.isEmpty()) {
				int[] cookedTomato = q.poll();
				
				for(int d = 0 ; d < dx.length ; d++) {
					int nx = cookedTomato[1] + dx[d];
					int ny = cookedTomato[2] + dy[d];
					int nz = cookedTomato[0] + dz[d];
					
					if(nx >= N || nx < 0 || ny >= M || ny < 0 || nz >= H || nz < 0) continue;
					if(visit[nz][nx][ny]) continue;
					
					visit[nz][nx][ny] = true;
					if(tomato[nz][nx][ny] == 0) {
						tomato[nz][nx][ny] = 1;
						copyQ.add(new int[] {nz,nx,ny});
						rawTomato --;
					}
				}
			}
			if(copyQ.size() > 0) {
				answer++;
			}
			
			q = copyQ;
			
		}
		
	}

}

