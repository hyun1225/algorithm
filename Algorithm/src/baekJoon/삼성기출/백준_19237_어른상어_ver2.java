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

public class 백준_19237_어른상어_ver2 {
	
	public static smell[][] map;
	public static smell[][] tmpMap;
	public static List<shark> sharkList;
	public static List<shark> tmpSharkList;
	public static int N,M,k,second = 0;
	public static int[][][] priority;
	public static int[] dx = {0, -1,1,0,0}; //위 아래 왼 오  
	public static int[] dy = {0, 0,0,-1,1};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_19237.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new smell[N][N];
		priority = new int[M+1][4+1][4+1];
		sharkList = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp > 0) {
					map[i][j] = new smell(tmp,k);
					sharkList.add(new shark(tmp,i,j));
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int[] tmp = new int[M+1];
		for(int i = 1 ; i <= M ; i ++) {
			tmp[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < sharkList.size(); i ++) {
			shark s = sharkList.get(i);
			s.direction = tmp[s.sharkNum];
		}
		
		for(int i = 1 ; i <= M ; i ++) {
			for(int j = 1 ; j <= 4 ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int a = 1; a <= 4 ; a++) {
					priority[i][j][a] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		while(true) {
			second++;
			if(second > 1000) {
				System.out.println(-1);
				return;
			}
			move();
			if(sharkList.size() == 1) {
				break;
			}
		}
		
		System.out.println(second);
		
	}
	
	private static void move() {
		tmpMap = new smell[N][N];
		mapCopy();
		tmpSharkList = new ArrayList<>();
		
		for(int i = 0 ; i < sharkList.size(); i ++) {
			shark s = sharkList.get(i);
			List<Integer> mySmellList = new ArrayList<>(); 
			boolean flag = false;
			//boolean[][] visit = new boolean[N][N];
			for(int d = 1 ; d <= 4 ; d++) {
				int priorityDirection = priority[s.sharkNum][s.direction][d];
				int nx = s.x + dx[priorityDirection];
				int ny = s.y + dy[priorityDirection];
				if(boundary(nx,ny)) {
					if(map[nx][ny] == null) {
						if(tmpMap[nx][ny] == null) {
							tmpMap[nx][ny] = new smell(s.sharkNum,k);
							tmpSharkList.add(new shark(s.sharkNum, priorityDirection, nx,ny));
							flag = true;
							break;
						}else {
							smell tmpSmell = tmpMap[nx][ny];
							if(tmpSmell.sharkNum > s.sharkNum) {
								tmpMap[nx][ny] = new smell(s.sharkNum,k);
								tmpSharkDelete(tmpSmell.sharkNum);
								tmpSharkList.add(new shark(s.sharkNum, priorityDirection, nx,ny));
							}
							flag = true;
							break;
						}
					}
				}
			}
			if(!flag) {
				for(int d = 1 ; d <= 4 ; d++) {
					int priorityDirection = priority[s.sharkNum][s.direction][d];
					int nx = s.x + dx[priorityDirection];
					int ny = s.y + dy[priorityDirection];
					if(boundary(nx,ny)) {
						if (map[nx][ny] != null && map[nx][ny].sharkNum == s.sharkNum) {
							tmpMap[nx][ny] = new smell(s.sharkNum, k);
							tmpSharkList.add(new shark(s.sharkNum, priorityDirection, nx, ny));
							flag = true;
							break;
						}
					}
				}
			}
			if(!flag) {
				tmpSharkList.add(new shark(s.sharkNum, s.direction, s.x, s.y));
			}
		}
		
		map = tmpMap;
		sharkList = tmpSharkList;
		
	}

	private static void mapCopy() {
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N ; j ++) {
				if(map[i][j] != null) {
					smell tmp = map[i][j];
					if(tmp.time-1 >0) {
						tmpMap[i][j] = new smell(tmp.sharkNum, tmp.time-1);
					}else {
						tmpMap[i][j] = null;
					}
				}
			}
		}
	}

	private static void tmpSharkDelete(int sharkNum) {
		for(int i = 0 ; i < tmpSharkList.size(); i ++) {
			if(tmpSharkList.get(i).sharkNum == sharkNum) {
				tmpSharkList.remove(i);
			}
		}
		
	}

	private static boolean boundary(int nx, int ny) {
		// TODO Auto-generated method stub
		if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
			return false;
		}
		return true;
	}

	static class smell{
		int sharkNum;
		int time;
		
		smell(int sharkNum, int time){
			this.sharkNum = sharkNum;
			this.time =  time;
		}
	}
	
	static class shark{
		int sharkNum;
		int direction;
		int x;
		int y;
		
		
		shark(int sharkNum, int x, int y){
			this.sharkNum = sharkNum;
			this.x = x;
			this.y = y;
		}
		
		shark(int sharkNum, int direction ,int x, int y){
			this.sharkNum = sharkNum;
			this.direction = direction;
			this.x = x;
			this.y = y;
		}
	}
	

}

