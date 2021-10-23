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

public class 백준_2644_촌수계산_ver2 {
	
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
		
		visit[start] = true;
		dfs(start,0);
		System.out.println(chonSu);
		
	}
	
	public static void dfs(int person, int depth) {
		
		if(person == end) {
			chonSu = depth;
			gameEnd = true;
			return;
		}
		
		for(int i = 0 ; i < n; i ++) {
			if(gameEnd) break;
			if(visit[i]) continue;
			if(relation[person][i] == 1) {
				visit[i] = true;
				dfs(i, depth + 1);
			}
		}
		
	}

}

