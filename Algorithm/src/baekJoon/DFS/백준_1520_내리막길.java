package baekJoon.DFS;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 백준_1520_내리막길 {
	

	static int[][] graph;
	static int[][] dp;
	static int M, N;
	static int[] dx = {-1, 1,0,0 };
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1520.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		graph = new int[M + 1][N + 1];
		dp = new int[M + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			s = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(s[j - 1]);
				dp[i][j] = -1;
			}
		}
		int res = dfs(1,1);
		bw.write(res + "\n");
		bw.flush();
		
	}
	
	public static int dfs(int i,int j) {

		dp[i][j] = 0;

		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];

			if ((1 <= nx && nx <= M) && (1 <= ny && ny <= N)) {

				if (graph[nx][ny] < graph[i][j]) {
					if (nx == M && ny == N) {
						dp[i][j] += 1;
					}
					if (dp[nx][ny] >= 0) // >에서 >=로 바꿈
						dp[i][j] += dp[nx][ny];
					else {
						int cnt = dfs(nx,ny);
						dp[i][j] += cnt;
					}
				}
			}
		}

		return dp[i][j];
	}

}

