package baekJoon.삼성기출;

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

public class 백준_17142_연구소3 {
	public static String[][] map, tmpMap;
	public static int N, M;
	public static virus[] availableVirusList;
	public static List<virus> activeVirusList;
	public static int blank = 0;
	public static int minTime = Integer.MAX_VALUE;
	public static boolean[] visit;
	public static boolean[][] visitMap;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static Queue<virus> q, tmpQ;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_17142.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new String[N][N];
		availableVirusList = new virus[10];
		activeVirusList = new LinkedList<>();

		int k = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 2) { // 바이러스
					availableVirusList[k] = new virus(i, j);
					k++;
					map[i][j] = "비활";
				} else if (a == 0) { // 빈칸
					blank++;
					map[i][j] = "빈칸";
				} else { // 벽
					map[i][j] = "-";
				}
			}
		}
		/*
		if (blank == 0) {
			System.out.println(0);
			return;
		}
		*/
		visit = new boolean[10];

		virusSelect(0, 0);

		if (minTime == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		} else {
			System.out.println(minTime);
		}
		return;

	}

	private static void virusSelect(int virusCnt, int start) {

		if (virusCnt == M) {
			bfs();
			return;
		}

		for (int i = start; i < availableVirusList.length; i++) {
			if (availableVirusList[i] == null) {
				break;
			}
			if (!visit[i]) {
				visit[i] = true;
				int x = availableVirusList[i].x;
				int y = availableVirusList[i].y;
				activeVirusList.add(new virus(x, y));
				map[x][y] = "활";
				virusSelect(virusCnt + 1, i + 1);
				activeVirusList.remove(virusCnt);
				map[x][y] = "비활";
				visit[i] = false;
			}
		}

	}

	private static void bfs() {
		mapCopy();
		int tmpBlank = blank;
		int tmpTime = 0;
		visitMap = new boolean[N][N];
		q = new LinkedList<>();
		// tmpQ = new LinkedList<>();

		for (int i = 0; i < activeVirusList.size(); i++) {
			int x = activeVirusList.get(i).x;
			int y = activeVirusList.get(i).y;
			q.add(new virus(x, y));
		}

		while (true) {
			if (q.size() == 0 || tmpBlank == 0 || tmpTime > minTime) {
				break;
			}
			tmpTime++;
			tmpQ = new LinkedList<>();

			while (!q.isEmpty()) {
				virus tmpVirus = q.poll();
				visitMap[tmpVirus.x][tmpVirus.y] = true;

				for (int i = 0; i < dx.length; i++) {
					int nx = tmpVirus.x + dx[i];
					int ny = tmpVirus.y + dy[i];
					if (boundary(nx, ny)) {
						if (!visitMap[nx][ny]) {
							visitMap[nx][ny] = true;
							if (tmpMap[nx][ny].equals("빈칸")) {
								tmpBlank--;
								tmpQ.add(new virus(nx, ny));
								tmpMap[nx][ny] = tmpTime + "";
							} else if (tmpMap[nx][ny].equals("비활")) {
								tmpMap[nx][ny] = "활";
								tmpQ.add(new virus(nx, ny));
							}
						}
					}
				}
			}
			q = tmpQ;

		}

		if (tmpBlank == 0) {
			minTime = Math.min(minTime, tmpTime);
		}

	}

	private static boolean boundary(int nx, int ny) {
		if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
			return false;
		}
		return true;
	}

	private static void mapCopy() {
		tmpMap = new String[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmpMap[i][j] = map[i][j];
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

