package baekJoon.시뮬레이션;

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

public class 백준_11559_PUYOPUYO {
	

	public static String[][] map ;
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0}; //상 하 좌 우  
	public static int[] dy = {0,0,-1,1};
	public static List<int[]> list;
	public static int cnt, ans=0;
	public static boolean flag = false;
	//public static char[][] charMap;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_11559.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		map = new String[12][6];
		for(int i = 0 ; i < 12 ; i ++) {
			map[i] = br.readLine().split("");
		}
		
		/*
		//char형 2차원 배열로 입력 받
		charMap = new char[12][6];
		for(int i = 0 ; i < 12 ; i ++) {
			charMap[i] = br.readLine().toCharArray();
		}
		*/
		
		
		//dfs로 4이상 인것들 찾음
		//찾은후 없애고 남은것들을 내림  
		while(true) {
			visit = new boolean[12][6];
			flag = false;
			puyopuyoCheck();
			if(flag) {
				ans++;
			}else {
				break;
			}
			down();
		}
		
		System.out.println(ans);
		
		
	}

	private static void puyopuyoCheck() {
		for(int i = 0 ; i < 12 ; i++) {
			for(int j = 0 ; j < 6 ; j ++) {
				if(!visit[i][j] && !map[i][j].equals(".")) {
					list = new ArrayList<>();
					list.add(new int[] {i,j});
					visit[i][j] = true;
					dfs(i,j);
					if(list.size() >= 4) {
						for(int l = 0 ; l < list.size() ; l ++) {
							map[list.get(l)[0]][list.get(l)[1]] = ".";
						}
						flag = true;
					}
				}
			}
		}
	}

	/* 방법1
	//
	private static void down() {
		for(int i = 11 ; i >= 0 ; i --) {
			for(int j = 0 ; j < 6 ; j ++) {
				if(!map[i][j].equals(".")) {
					int nx = i ;
					int ny = j ;
					String tmp = map[i][j];
					while(true) {
						nx = nx + 1;
						ny = ny;
						if(!areaCheck(nx, ny)) break;
						if(!map[nx][ny].equals(".")) break;
						map[nx][ny] = tmp;
						map[nx-1][ny] = ".";
					}
				}
			}
		}
		
	}
	*/
	
	//방법2
	private static void down() {
		for (int i = 0; i < 6; i++) {
			for (int j = 10; j >= 0; j--) {
				for (int k = 11; k > j; k--) {
					if (!".".equals(map[j][i]) && ".".equals(map[k][i])) {
						map[k][i] = map[j][i];
						map[j][i] = ".";
						break;
					}
				}
			}
		}
	}

	private static void dfs(int i, int j) {
		
		for(int d = 0 ; d < dx.length ; d ++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if(!areaCheck(nx,ny)) continue;
			if(map[i][j].equals(map[nx][ny]) && !visit[nx][ny]) {
				list.add(new int[]{nx,ny});
				visit[nx][ny] = true;
				dfs(nx,ny);
			}
		}
		
	}

	private static boolean areaCheck(int nx, int ny) {
		if( nx < 0 || nx >=12 || ny < 0 || ny >= 6) return false;
		else return true;
	}

}

