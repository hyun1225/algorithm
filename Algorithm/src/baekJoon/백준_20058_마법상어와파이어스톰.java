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

public class 백준_20058_마법상어와파이어스톰 {
	

	public static int N,Q,range, cnt;
	public static int[][] map, tmpMap, iceCheckTmpMap;
	public static int[] L;
	public static int[] dx = {-1,1,0,0}; //상 하 좌 우 
	public static int[] dy = {0,0,-1,1}; 
	public static int max = Integer.MIN_VALUE;
	public static int iceSum=0;
	public static boolean[][] visit;
	
	public static void main(String[] args) throws IOException  {
		System.setIn(new FileInputStream("res/백준input_20058.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		range = (int) Math.pow(2, N);
		map = new int[range][range];
		L = new int[Q];
		visit = new boolean[range][range];
		
		for(int i = 0 ; i < range ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < range ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < Q ; i ++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		fireStorm();
		calc();
		
		System.out.println(iceSum);
		if(max == Integer.MIN_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(max);
		}
		
	}

	private static void calc() {
		for(int i = 0 ; i < range; i ++) {
			for(int j = 0 ; j < range ; j ++) {
				if(!visit[i][j] && map[i][j] > 0) {
					visit[i][j] = true;
					iceSum += map[i][j];
					cnt = 1;
					dfs(i,j);
					if(cnt > 1) {
						max = Math.max(max, cnt);
					}
				}
			}
		}
		
	}

	private static void dfs(int i, int j) {
		
		for(int d = 0 ; d < dx.length ; d ++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if(nx < 0 || nx >= range || ny < 0 || ny >=range) continue;
			if(visit[nx][ny]) continue;
			if(map[nx][ny] <= 0) continue;
			visit[nx][ny] = true;
			iceSum += map[nx][ny];
			cnt++;
			dfs(nx,ny);
		}
		
	}

	private static void fireStorm() {
		for(int i = 0 ; i < Q ; i ++) {
			int smallRange = (int) Math.pow(2, L[i]);
			rotate(smallRange);
			iceCheck();
			map = tmpMap;
		}
	}

	private static void iceCheck() {
		iceCheckTmpMap = new int[range][range];
		for(int i = 0 ; i < range; i ++) {
			for(int j = 0 ; j < range ; j ++) {
				if(tmpMap[i][j] > 0) {
					int cnt = 0 ;
					for(int d = 0 ; d < dx.length ; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if(nx < 0 || nx >= range || ny < 0 || ny >=range) continue;
						if(tmpMap[nx][ny] <= 0) continue;
						cnt ++;
					}
					if(cnt < 3) {
						//tmpMap[i][j] --;
						int ice = tmpMap[i][j] - 1 ;
						if(ice > 0) {
							iceCheckTmpMap[i][j] = ice;
						}
					}else {
						iceCheckTmpMap[i][j] = tmpMap[i][j];
					}
				}
			}
		}
		tmpMap = iceCheckTmpMap ;
	}

	private static void rotate(int smallRange) {
		tmpMap = new int[range][range];
		for(int i = 0; i <= range - smallRange; i+=smallRange) {
			for(int j = 0; j <= range - smallRange; j+=smallRange) {
				realRotate(i,j,smallRange);
			}
		}
	}

	private static void realRotate(int i, int j, int smallRange) {
		for(int a = j, d=i ; a < j+smallRange; a++, d++) {
			for(int b = i, c=0 ; b < i+smallRange; b++, c++) {
				tmpMap[d][(j+smallRange-1)-c] = map[b][a];
			}
		}
		
	}
	

}

