package baekJoon.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
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

public class 백준_11725_트리의부모찾기 {
	

	static int N;
	static List<Integer>[] tree;
	static boolean[] visit;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_11725.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList[N+1];
		visit = new boolean[N+1];
		answer = new int[N+1];
		
		for(int i = 0 ; i < N+1; i ++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < N-1 ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
        for(int i=2; i <= N; i++){
            sb.append(answer[i]).append("\n");
        }
        
        System.out.println(sb);
		
		
	}

	private static void dfs(int num) {
		
		visit[num] = true;
		
		List<Integer> list = tree[num];
		for(int i = 0 ; i < list.size() ; i ++) {
			int node = list.get(i);
			if(!visit[node]) {
				answer[node] = num;
				dfs(node);
			}
		}
		
		
	}

}

