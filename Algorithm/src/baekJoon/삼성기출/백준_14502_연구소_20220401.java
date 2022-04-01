package baekJoon.삼성기출;

import java.util.ArrayList;
import java.util.*;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.*;
import java.util.Queue;
import java.util.Scanner;
import java.util.Scanner;

public class 백준_14502_연구소_20220401 {

	public static int[][] map;
	// public static Queue<virus> q;
	static int N, M;
	static int ans = Integer.MIN_VALUE;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_14502.txt"));
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

		makeWall(0);
		System.out.println(ans);

	}

	private static void makeWall(int depth) {
		if (depth == 3) {
			// 바이러스 전파
			spreadVirus();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(depth + 1);
					map[i][j] = 0;
				}
			}
		}

	}

	private static void spreadVirus() {
		int[][] copyMap = new int[N][M];
		Queue<virus> q = new LinkedList<>();

		copy(copyMap, q);
		spread(copyMap, q);
		safeArea(copyMap);

	}

	private static void safeArea(int[][] copyMap) {
		// 안전영역 구하기
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		ans = Math.max(ans, cnt);

	}

	private static void spread(int[][] copyMap, Queue<virus> q) {
		// 바이러스 퍼트리기
		while (!q.isEmpty()) {
			virus tmp = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (copyMap[nx][ny] == 0) {
					copyMap[nx][ny] = 2;
					q.add(new virus(nx, ny));
				}
			}
		}

	}

	private static void copy(int[][] copyMap, Queue<virus> q) {
		// 맵 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
				if (copyMap[i][j] == 2) {
					q.add(new virus(i, j));
				}
			}
		}

	}

	static class virus {
		int x;
		int y;

		virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

