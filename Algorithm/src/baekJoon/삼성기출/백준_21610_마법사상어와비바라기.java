package baekJoon.삼성기출;

import java.util.ArrayList;
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

public class 백준_21610_마법사상어와비바라기 {
	

	public static int[][] map;
	public static int N, M, waterSum=0;
	public static boolean[][] visit, tmpVisit;
	public static List<MoveInfo> moveInfoList;
	public static List<Cloud> cloudList, tmpCloudList;
	public static int[] dx = {0,-1,-1,-1,0,1,1,1};
	public static int[] dy = {-1,-1,0,1,1,1,0,-1};
	public static int[] diagonalX = {-1,-1,1,1};
	public static int[] diagonalY = {-1,1,-1,1};
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_21610.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		moveInfoList = new ArrayList<>();
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int moveCnt = Integer.parseInt(st.nextToken());
			moveInfoList.add(new MoveInfo(dir, moveCnt));
		}
		
		init();
		
		for(int i = 0 ; i < M ; i ++) {
			moveCloud(i);
			rain();
			waterCopyBug();
			makeCloud();
		}
		
		System.out.println(getWaterSum());
		
		
	}

	private static void init() {
		cloudList = new ArrayList<>();
		cloudList.add(new Cloud(N-1,0));
		cloudList.add(new Cloud(N-1,1));
		cloudList.add(new Cloud(N-2,0));
		cloudList.add(new Cloud(N-2,1));
		
		visit = new boolean[N][N];
		visit[N-1][0] = true;
		visit[N-1][1] = true;
		visit[N-2][0] = true;
		visit[N-2][1] = true;
	}

	private static int getWaterSum() {
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N ; j ++) {
				waterSum += map[i][j];
			}
		}
		return waterSum;
	}

	private static void makeCloud() {
		tmpCloudList = new ArrayList<>();
		tmpVisit = new boolean[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j ++) {
				if(map[i][j] >= 2 && !visit[i][j]) {
					tmpCloudList.add(new Cloud(i, j));
					tmpVisit[i][j] = true;
					map[i][j] -= 2;
				}
			}
		}
		cloudList = tmpCloudList;
		visit = tmpVisit;
	}

	private static void waterCopyBug() {
		for(int i = 0 ; i < cloudList.size(); i ++) {
			int waterbasketCnt = 0;
			for(int k = 0 ; k < 4 ; k ++) {
				int nx = cloudList.get(i).x + diagonalX[k];
				int ny = cloudList.get(i).y + diagonalY[k];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(map[nx][ny] > 0) {
					waterbasketCnt ++;
				}
			}
			map[cloudList.get(i).x][cloudList.get(i).y] += waterbasketCnt;
		}
		
	}

	private static void rain() {
		for(int i = 0 ; i < cloudList.size(); i ++) {
			map[cloudList.get(i).x][cloudList.get(i).y] ++; 
		}
	}

	private static void moveCloud(int i) {
		MoveInfo moveInfo = moveInfoList.get(i);
		int tmpMoveCnt = moveInfo.moveCnt % N ;
		int tmpDir = moveInfo.dir;
		tmpVisit = new boolean[N][N];
		
		for(int k = 0 ; k < cloudList.size(); k ++) {
			int nx = cloudList.get(k).x + (tmpMoveCnt * dx[tmpDir]);
			int ny = cloudList.get(k).y + (tmpMoveCnt * dy[tmpDir]);
			if(nx >= N) {
				nx = nx-N;
			}else if(nx < 0) {
				nx = nx+N;
			}
			if(ny >= N) {
				ny = ny-N;
			}else if(ny < 0) {
				ny = ny+N;
			}
			tmpVisit[nx][ny] = true;
			cloudList.get(k).x = nx;
			cloudList.get(k).y = ny;
		}
		visit = tmpVisit ;
	}

	static class MoveInfo{
		int dir;
		int moveCnt;
		
		MoveInfo(int dir, int moveCnt) {
			this.dir = dir;
			this.moveCnt = moveCnt;
		}
	}
	
	static class Cloud{
		int x;
		int y;
		
		Cloud(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

