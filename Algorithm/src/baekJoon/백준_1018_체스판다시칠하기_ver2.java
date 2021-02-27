package baekJoon;

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

public class 백준_1018_체스판다시칠하기_ver2 {
	
	public static int N, M;
	public static char[][] map, tmpMap;
	public static int min = Integer.MAX_VALUE;
	public static boolean[][] visit;
	public static int[] dx = {0,0,-1,1}; // 상 하 좌 
	public static int[] dy = {-1,1,0,0};
	public static int cnt;
	
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1018.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i = 0 ; i < N ; i ++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < M ; j ++) {
				//map[i][j] = tmp.substring(j,j+1);
				map[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i = 0 ; i <= N-8; i ++) {
			for(int j = 0; j<= M-8; j ++) {
				init(i,j);
				dfs(0,0);
				cnt = Math.min(cnt, 64-cnt);
				min = Math.min(min, cnt);
			}
		}
		
		System.out.println(min);
		
	}


	private static void init(int i, int j) {
		tmpMap = new char[8][8];
		visit = new boolean[8][8];
		cnt = 0;
		for(int a = 0 , q = i; a < tmpMap.length ; a++, q++) {
			for(int b = 0, k = j ; b < tmpMap.length ; b++, k++) {
				tmpMap[a][b] = map[q][k];
			}
		}
	}


	private static void dfs(int i , int j) {
		
		visit[i][j] = true;
		for(int d = 0 ; d < dx.length; d ++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
			if(visit[nx][ny]) continue;
			
			if(tmpMap[i][j] == tmpMap[nx][ny]) {
				if(tmpMap[i][j] == 'W') {
					tmpMap[nx][ny] = 'B';
				}else {
					tmpMap[nx][ny] = 'W';
				}
				cnt ++;
			}
			dfs(nx,ny);
		}
		
	}

}

