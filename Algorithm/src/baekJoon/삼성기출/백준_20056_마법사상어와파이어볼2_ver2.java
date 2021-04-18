package baekJoon.삼성기출;

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

public class 백준_20056_마법사상어와파이어볼2_ver2 {
	
	static int n;
	static ArrayList<FireBall> map[][];
	static int dx[] = {-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_20056.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		int k = Integer.parseInt(stz.nextToken());
		map = new ArrayList[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stz.nextToken()) - 1;
			int c = Integer.parseInt(stz.nextToken()) - 1;
			int m = Integer.parseInt(stz.nextToken());
			int s = Integer.parseInt(stz.nextToken());
			int d = Integer.parseInt(stz.nextToken());
			map[r][c].add(new FireBall(m, d, s));
		}
		for (int i = 0; i < k; i++)
			move();
		System.out.println(sum());

	}

	public static void move() {
		ArrayList<FireBall> next[][] = new ArrayList[n][n];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				next[i][j] = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].size() >= 1) {
					for (FireBall fb : map[i][j]) {
						int distance = fb.s % n;
						int x = i + dx[fb.d] * distance;
						int y = j + dy[fb.d] * distance;
						if (x >= n)
							x -= n;
						else if (x < 0)
							x += n;
						if (y >= n)
							y -= n;
						else if (y < 0)
							y += n;
						next[x][y].add(new FireBall(fb.m, fb.d, fb.s));
					}
				}
			}
		}
		map = next;
		split();
	}

	public static void split() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].size() >= 2) {
					int mSum = 0;
					int sSum = 0;
					boolean even = true, odd = true;
					for (FireBall fb : map[i][j]) {
						mSum += fb.m;
						sSum += fb.s;
						if (fb.d % 2 == 0)
							odd = false;
						else
							even = false;
					}
					int m = mSum / 5;
					int s = sSum / map[i][j].size();
					map[i][j].clear();
					if (m > 0) {
						for (int a = 0; a < 4; a++) {
							if (odd || even)
								map[i][j].add(new FireBall(m, 0 + 2 * a, s));
							else
								map[i][j].add(new FireBall(m, 1 + 2 * a, s));
						}
					}
				}
			}
		}
	}

	public static long sum() {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (FireBall fb : map[i][j])
					sum += fb.m;
			}
		}
		return sum;
	}

	static class FireBall {
		int m, d, s;

		FireBall(int m, int d, int s) {
			this.m = m;
			this.d = d;
			this.s = s;
		}
	}

}

