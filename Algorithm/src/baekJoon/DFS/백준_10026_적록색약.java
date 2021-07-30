package baekJoon.DFS;

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
					dfs(i,j,map[i][j],false);
				}
				if(!visitBlindness[i][j]) {
					visitBlindness[i][j] = true;
					answer[1]++;
					dfs(i,j,map[i][j],true);
				}
			}
		}
		
		System.out.println(answer[0] + " " + answer[1]);
		
		
	}

	private static void dfs(int i, int j, char color, boolean blindness) {
		
		if(!blindness) {
			//정상 
			for(int d = 0 ; d < 4 ; d ++) {
				int nx = i + dx[d];
				int ny = j + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(visit[nx][ny]) continue;
				if(color != map[nx][ny]) continue;
				visit[nx][ny] = true;
				dfs(nx,ny,color,blindness);
			}
		}else {
			//적록색약 
			for(int d = 0 ; d < 4 ; d ++) {
				int nx = i + dx[d];
				int ny = j + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(visitBlindness[nx][ny]) continue;
				if(color == 'R' || color == 'G') {
					if( map[nx][ny] == 'R' || map[nx][ny] == 'G' ) {
						visitBlindness[nx][ny] = true;
						dfs(nx,ny,map[nx][ny],blindness);
					}
				}else {
					if( color == map[nx][ny] ) {
						visitBlindness[nx][ny] = true;
						dfs(nx,ny,map[nx][ny],blindness);
					}
				}
				
			}
		}
	}

}

