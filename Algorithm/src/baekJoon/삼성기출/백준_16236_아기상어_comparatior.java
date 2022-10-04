package baekJoon.삼성기출;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

public class 백준_16236_아기상어_comparatior {
	

	static int N;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int time, eatCnt, eatFishX, eatFishY;
	static int eatFishDist = Integer.MAX_VALUE;
	static SharkInfo sharkInfo;
	/*
	 * 1.아기상어의 위치, 크기 
	 * 
	 */

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_16236.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sharkInfo = new SharkInfo(i, j, 2);
					map[i][j] = 0;
				}
			}
		}
		
		process();
		System.out.println(time);
	}
	
	
	
	private static void process() {
		while(true) {
			
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{sharkInfo.x, sharkInfo.y});
			int[][] dist = new int[N][N];
			LinkedList<fish> fishList = new LinkedList<>();
			
			while(!q.isEmpty()) {
				int[] now = q.poll();
				
				for(int i = 0 ; i < 4 ; i ++) {
					int nx = now[0] + dx[i];
					int ny = now[1] + dy[i];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(dist[nx][ny] > 0) continue;
					if(map[nx][ny] > sharkInfo.size) continue;
					
					dist[nx][ny] = dist[now[0]][now[1]] + 1;
					q.add(new int[]{nx,ny});
					
					if(map[nx][ny] > 0 && map[nx][ny] < sharkInfo.size) {
						fishList.add(new fish(nx,ny,dist[nx][ny]));
					}
				}
			}
			
			//먹을 물고기 없을시 종료 
			if(fishList.size() == 0) {
				break;
			}
			
			Collections.sort(fishList, comp);
			
			//물고기 먹고, 상어크기 체크하고, 상어 위치 변경 시키고, 먹을 물고기 변수 초기, 먹은 물고기 자리 없애
			eatCnt ++;
			time += fishList.get(0).distance;
			sharkInfo.x = fishList.get(0).x ;
			sharkInfo.y = fishList.get(0).y ;
			map[fishList.get(0).x][fishList.get(0).y] = 0;
			
			if(eatCnt == sharkInfo.size) {
				eatCnt = 0;
				sharkInfo.size ++;
			}
			
		}
	}

	static class SharkInfo{
		int x;
		int y;
		int size;
		
		public SharkInfo(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
	
	static class fish{
		int x;
		int y;
		int distance;
		
		public fish(int x, int y, int distance) {
			this.x=x;
			this.y=y;
			this.distance=distance;
		}
	}
	
	static Comparator<fish> comp = new Comparator<fish>(){

		@Override
		public int compare(fish o1, fish o2) {
			if(o1.distance > o2.distance) {
				return 1;
			}else if(o1.distance == o2.distance) {
				if(o1.x > o2.x) {
					return 1;
				}else if(o1.x == o2.x) {
					if(o1.y > o2.y) {
						return 1;
					}
				}
			}
			
			return -1;
		}
		
	};

}

