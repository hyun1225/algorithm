package baekJoon.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

public class 백준_2636_치즈_dfs_ver2 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int cheeseCnt;
	static int[] rangeX = { -1, 0, 1, 0 };
	static int[] rangeY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_2636.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		

		int ans;
		for (ans = 0; isCheese(); ans++) {
			visited = new boolean[N][M];
			visited[0][0] = true;
			cheeseCnt = 0;
			DFS(0, 0);
		}
		
		System.out.println(ans);
		System.out.println(cheeseCnt);
		
	}

	public static boolean isCheese() {

		// 판 위에 치즈가 존재하는지 체크.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					return true;
				}
			}
		}

		return false;
	}

	// (0, 0)부터 시작해서 공기와 맞닿은 치즈를 찾음.
	public static void DFS(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int dx = x + rangeX[i];
			int dy = y + rangeY[i];

			// 범위를 벗어나는 경우
			if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
				continue;
			}

			if (!visited[dx][dy]) {
				visited[dx][dy] = true;
				if (map[dx][dy] == 1) {
					map[dx][dy] = 0;
					cheeseCnt++; // 다음에 지워질 치즈의 개수
				} else {
					DFS(dx, dy);
				}
			}
		}
	}

}

