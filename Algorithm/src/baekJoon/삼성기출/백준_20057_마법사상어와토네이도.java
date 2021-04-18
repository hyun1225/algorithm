package baekJoon.삼성기출;

import java.util.ArrayList;
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

public class 백준_20057_마법사상어와토네이도 {
	
	public static int[][] map;	
	public static int N,answer =0 ,direction=0;
	public static int[] nowPos;
	public static int[] dx = {0,1,0,-1};//서 남 동 
	public static int[] dy = {-1,0,1,0};
	public static int[][] westRatio = {{-1,1,1},{1,1,1},{-1,0,7},{1,0,7}
									  ,{-1,-1,10},{1,-1,10},{-2,0,2},{2,0,2}
									  ,{0,-2,5}};
	public static int[][] southRatio = {{-1,-1,1},{-1,1,1},{0,-1,7},{0,1,7}
									  ,{1,-1,10},{1,1,10},{0,-2,2},{0,2,2}
									  ,{2,0,5}};
	public static int[][] eastRatio = {{-1,-1,1},{1,-1,1},{-1,0,7},{1,0,7},
									   {-1,1,10},{1,1,10},{-2,0,2},{2,0,2},
									   {0,2,5}};
	public static int[][] northRatio = {{1,-1,1},{1,1,1},{0,-1,7},{0,1,7},
										{-1,-1,10},{-1,1,10},{0,-2,2},{0,2,2},
										{-2,0,5}};
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_20057.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		
		nowPos  = new int[] {N/2,N/2};
		map = new int[N][N];
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int length = 1;
		int cnt = 1;
		while(true) {
			
			if(length == N) break;
			if(length != N-1) {
				cnt = 2;
			}else {
				cnt = 3;
			}
			while (cnt >= 1) {
				int[][] tmpRatio = ratioCheck(direction);
				for (int i = 1; i <= length; i++) {
					int nx = nowPos[0] + dx[direction];
					int ny = nowPos[1] + dy[direction];
					int totalSand = map[nx][ny];
					for (int j = 0; j < 9; j++) {
						int spreadX = nx + tmpRatio[j][0];
						int spreadY = ny + tmpRatio[j][1];
					//	int spreadMount = (totalSand / 100) * tmpRatio[j][2];
					//	int spreadMount = (int)( (double)totalSand *(double)((double)1 / (double)100 * (double)tmpRatio[j][2])) ;
						int spreadMount = (totalSand*tmpRatio[j][2])/100;
						if(spreadX >= N || spreadY >=N || spreadX < 0 || spreadY < 0) {
							answer += spreadMount;
						}else {
							map[spreadX][spreadY] += spreadMount;
						}
						map[nx][ny] -= spreadMount;
					}
					int ax = nx+dx[direction];
					int ay = ny+dy[direction];
					if(ax >= N || ax < 0 || ay >= N || ay < 0) answer += map[nx][ny];
					else map[ax][ay] += map[nx][ny];
					map[nx][ny] = 0;
					nowPos[0] = nx;
					nowPos[1] = ny;
				}
				direction++;
				if (direction == 4) direction = 0;
				cnt--;
			}
			length++;
			
		}
		
		System.out.println(answer);
		
	}


	private static int[][] ratioCheck(int d) {
		if(d == 0) return westRatio;
		else if(d == 1) return southRatio;
		else if(d == 2) return eastRatio;
		else return northRatio;
	}

}

