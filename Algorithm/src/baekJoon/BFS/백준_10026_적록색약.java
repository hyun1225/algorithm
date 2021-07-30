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

public class 백준_10026_적록색약 {
	

	public static int N ;
	public static char[][] map;
	public static boolean[][] visit;
	public static boolean[][] visitBlindness;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int[] answer = {0,0};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_10026.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		visit = new boolean[N][N];
		visitBlindness = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i ++) {
			String str = br.readLine();
			//map[i] = str.toCharArray();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N ; j ++) {
				if(!visit[i][j]) {
					visit[i][j] = true;
					answer[0]++;
					bfs(i,j,map[i][j],false);
				}
				if(!visitBlindness[i][j]) {
					visitBlindness[i][j] = true;
					answer[1]++;
					bfs(i,j,map[i][j],true);
				}
			}
		}
		
		System.out.println(answer[0] + " " + answer[1]);
		
	}
	
	private static void bfs(int i, int j, char color, boolean blindness) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		
		if(!blindness) {
			while(!q.isEmpty()) {
				int[] pos = q.poll();
				
				for(int d = 0 ; d < 4 ; d ++) {
					int nx = pos[0] + dx[d];
					int ny = pos[1] + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(visit[nx][ny]) continue;
					if(color != map[nx][ny]) continue;
					visit[nx][ny] = true;
					q.add(new int[] {nx,ny});
					
				}
				
			}	
		}else {
			while(!q.isEmpty()) {
				int[] pos = q.poll();
				
				for(int d = 0 ; d < 4 ; d ++) {
					int nx = pos[0] + dx[d];
					int ny = pos[1] + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(visitBlindness[nx][ny]) continue;
					if(color == 'R' || color == 'G') {
						if( map[nx][ny] == 'R' || map[nx][ny] == 'G' ) {
							visitBlindness[nx][ny] = true;
							q.add(new int[] {nx,ny});
						}
					}else {
						if( color == map[nx][ny] ) {
							visitBlindness[nx][ny] = true;
							q.add(new int[] {nx,ny});
						}
					}
					
				}
			}
		}
	}

}

