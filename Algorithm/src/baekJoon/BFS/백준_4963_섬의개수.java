package baekJoon.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Scanner;
import java.io.FileInputStream;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.FileNotFoundException;

public class 백준_4963_섬의개수 {
	
	public static int[][] map ;
	public static boolean[][] visit;
	public static int[] dx = {-1,0,1,-1,1,-1,0,1};
	public static int[] dy = {-1,-1,-1,0,0,1,1,1};
	public static int answer = 0;
	public static int w,h;
	

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/백준input_4963.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if(w==0 && h ==0) {
				break;
			}
			
			answer = 0;
			map = new int[h][w];
			visit = new boolean[h][w];
			
			for(int i = 0 ; i < h; i ++) {
				for(int j = 0 ; j < w ; j++) {
					map[i][j] = sc.nextInt();
					
				}
			}
			
			for(int i = 0; i < h; i ++) {
				for(int j=0; j<w; j++) {
					if(!visit[i][j] && map[i][j] == 1 ) {
						bfs(i,j);
					}
				}
			}
			
			System.out.println(answer);
		}
		return;
		
	}


	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		visit[i][j] = true;
		answer ++;
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			
			for(int d = 0 ; d < dx.length; d++) {
				int nx = pos[0] + dx[d];
				int ny = pos[1] + dy[d];
				if(nx < 0 || nx >= h || ny < 0 || ny >= w) {
					continue;
				}
				if(visit[nx][ny]) continue;
				if(map[nx][ny] == 0) continue;
				visit[nx][ny] = true;
				q.add(new int[] {nx,ny});
			}
		}
		
		
	}

}

