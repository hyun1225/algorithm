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

public class 백준_2644_촌수계산 {
	
	static int n, start, end, m;
	static int[][] relation;
	static int chonSu = -1;
	static boolean[] visit;
	static boolean gameEnd = false;
	
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_2644.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		relation = new int[n][n];
		visit = new boolean[n];
		
		start = Integer.parseInt(st.nextToken())-1;
		end = Integer.parseInt(st.nextToken())-1;
		
		m = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			relation[x][y] = 1;
			relation[y][x] = 1;
		}
		
		bfs();
		System.out.println(chonSu);
		
	}
	
	private static void bfs() {
		
		Queue<int[]> q = new LinkedList<>();
		
		visit[start] = true;
		q.add(new int[] {start, 0});
		
		while(!q.isEmpty()) {
			int[] info = q.poll();
			
			for(int i = 0 ; i < n; i ++) {
				if(visit[i]) continue;
				if(relation[info[0]][i] == 0) continue;
				if(i == end) {
					chonSu = info[1] + 1;
					return;
				}else {
					visit[i] = true;
					q.add(new int[] {i, info[1]+1});
				}
			}
		}
		
	}

	public static void dfs(int person, int depth) {
		visit[person] = true;
		
		for(int i = 0 ; i < n ; i ++) {
			if(gameEnd) break;	
			if(visit[i]) continue;
			if(relation[person][i] == 1) {
				if(i == end) {
					chonSu = depth + 1;
					gameEnd = true;
					break;
				}else {
					dfs(i, depth+1);
				}
			}
		}
		
	}

}

