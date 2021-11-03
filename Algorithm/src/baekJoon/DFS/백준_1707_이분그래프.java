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

public class 백준_1707_이분그래프 {
	

	static int testCase,V,E;
	static ArrayList<Integer>[] graph;
	static int[] visit, checkVisit;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_1707.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		
		for(int i = 0 ; i < testCase ; i ++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[V+1];
			visit = new int[V+1];
			flag = true;
			
			for(int j = 0 ; j < V+1 ; j ++) {
				graph[j] = new ArrayList<>();
			}
			
			for(int j = 0 ; j < E ; j ++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graph[b].add(a);
			}
			
			for(int j = 1 ; j <= V ; j ++) {
				if(visit[j] == 0) {
					dfs(j,1);
				}
			}
			
			for(int j = 1 ; j <= V ; j ++) {
				
				for(int k = 0 ; k < graph[j].size() ; k ++) {
					if(visit[j] == visit[graph[j].get(k)]) {
						flag = false;
						break;
					}
				}
			}
			
			
			if(flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	
	private static void check(int num) {
		
		checkVisit[num] = 1;
		
		for(int i = 0 ; i < graph[num].size(); i ++) {
			if(flag == false) return;
			
			int linkNum = graph[num].get(i);
			
			if(checkVisit[linkNum] != 0) continue;
			
			if(visit[num] == visit[linkNum]) {
				flag = false;
			}else {
				check(linkNum);
			}
		}
		
	}

	public static void dfs(int num, int team) {
		visit[num] = team;
		
		for(int i = 0 ; i < graph[num].size(); i ++) {
			
			if(visit[graph[num].get(i)] == 0) {
				dfs(graph[num].get(i) , 3-team);
			}
			
			/*
			if(flag == false) return;
			
			int linkNum = graph[num].get(i);
			if(visit[linkNum] == 0) {
				dfs(linkNum, 3-team);
			}else {
				if(visit[num] == visit[linkNum]) {
					flag = false;
				}
			}
			*/
			
		}
	}

}

