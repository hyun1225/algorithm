package baekJoon.삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.*;
import java.util.Queue;
import java.util.Scanner;
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

public class 백준_21608_상어초등학교_답안참조 {
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_21608.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());

		int total = N * N;
		int[][] map = new int[N][N];

		boolean[][] info = new boolean[total + 1][];
		info[0] = new boolean[total];

		for (int i = 0; i < total; i++) {
			st = new StringTokenizer(in.readLine(), " ");

			int me = Integer.parseInt(st.nextToken());
			boolean[] isLiked = new boolean[total + 1];

			for (int j = 0; j < 4; j++) {
				int friend = Integer.parseInt(st.nextToken());
//			info[me][j] = friend;
				isLiked[friend] = true;
			}
			info[me] = isLiked;

			if (i == 0)
				map[1][1] = me;
			else
				findInfo(isLiked, map, N, me);
		}

		System.out.println(calcScore(map, N, info));
	}

	private static int calcScore(int[][] map, int N, boolean[][] info) {
		int total = N * N;
		int sum = 0;

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {

				int like = 0;
				int me = map[x][y];

				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						if (info[me][map[nx][ny]]) {
							// 좋아하는애가 주변에 있다.
							like++;
						}
					}
				}

				sum += getScore(like);
			}
		}
		return sum;

	}

	private static int getScore(int like) {
		switch (like) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 10;
		case 3:
			return 100;
		default:
			return 1000;
		}
	}

	private static void findInfo(boolean[] isLiked, int[][] map, int N, int me) {
		PriorityQueue<Position> pq = new PriorityQueue<Position>();

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (map[x][y] != 0)
					continue;

				int like = 0, blank = 0;

				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						if (map[nx][ny] == 0) {
							// 빈칸이 있다
							blank++;
						} else if (map[nx][ny] != 0 && isLiked[map[nx][ny]]) {
							// 좋아하는애가 주변에 있다.
							like++;
						}
					}
				}

				pq.offer(new Position(x, y, like, blank));
			}
		}

		Position p = pq.poll();
		map[p.x][p.y] = me;
	}

	static class Position implements Comparable<Position> {
		int x;
		int y;
		int like;
		int blank;

		public Position(int x, int y, int like, int blank) {
			super();
			this.x = x;
			this.y = y;
			this.like = like;
			this.blank = blank;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + ", like=" + like + ", blank=" + blank + "]";
		}

		@Override
		public int compareTo(Position o) {
			if (this.like == o.like) {
				if (this.blank == o.blank) {
					if (this.x == o.x) {
						return this.y - o.y;
					}
					return this.x - o.x;
				}
				return o.blank - this.blank;
			}
			return o.like - this.like;
		}

	}
}

