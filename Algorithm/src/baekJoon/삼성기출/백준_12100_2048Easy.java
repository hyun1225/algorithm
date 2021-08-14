package baekJoon.삼성기출;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Scanner;
import java.io.FileInputStream;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.FileNotFoundException;

public class 백준_ {
	
	static int N;
	static int max = Integer.MIN_VALUE;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_12100.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		game(0, map);
		System.out.println(max);
		
	}
	
	public static void game(int cnt, int[][] map) {
		if(cnt == 5) {
			return;
		}
		
		for(int i = 0 ; i < 4 ; i ++) {
			int[][] moveMap = move(map, i);
			game(cnt+1, moveMap);
		}
		
	}

	private static int[][] move(int[][] map, int direction) {
		
		int[][] returnMap = new int[N][N];
		
		switch(direction) {
			case 0:
				//위
				for(int col = 0 ; col < N ; col++) {
					int value = 0;
					int index = 0;
					for(int row = 0 ; row < N ; row ++) {
						if(map[row][col] != 0) {
							if(value == map[row][col]) {
								returnMap[index-1][col] *= 2;
								value = 0;
								max = Math.max(returnMap[index-1][col], max);
							}else {
								returnMap[index][col] = map[row][col];
								value = map[row][col];
								max = Math.max(returnMap[index][col], max);
								index++;
							}
						}
					}
				}
				
				break;
				
			case 1:
				//아래 
				for(int col = 0 ; col < N ; col++) {
					int value = 0;
					int index = N-1;
					for(int row = N-1 ; row >=0 ; row --) {
						if(map[row][col] != 0) {
							if(value == map[row][col]) {
								returnMap[index+1][col] *= 2;
								value = 0;
								max = Math.max(returnMap[index+1][col], max);
							}else {
								returnMap[index][col] = map[row][col];
								value = map[row][col];
								max = Math.max(returnMap[index][col], max);
								index--;
							}
							
						}
					}
				}
				break;
				
			case 2:
				//왼쪽 
				for(int row = 0 ; row < N ; row ++) {
					int value = 0;
					int index = 0;
					for(int col = 0; col < N ; col ++) {
						if(map[row][col] != 0) {
							if(value == map[row][col]) {
								returnMap[row][index-1] *= 2;  
								value = 0;
								max = Math.max(returnMap[row][index-1], max);
							}else {
								returnMap[row][index] = map[row][col];
								value = map[row][col];
								max = Math.max(returnMap[row][index], max);
								index ++;
							}
						}
					}
				}
				
				break;
				
			case 3:
				//오른쪽 
				for(int row = 0 ; row < N ; row ++) {
					int value = 0;
					int index = N-1;
					for(int col = N-1; col >= 0 ; col --) {
						if(map[row][col] != 0) {
							if(value == map[row][col]) {
								returnMap[row][index+1] *= 2;  
								value = 0;
								max = Math.max(returnMap[row][index+1], max);
							}else {
								returnMap[row][index] = map[row][col];
								value = map[row][col];
								max = Math.max(returnMap[row][index], max);
								index --;
							}
						}
					}
				}
				break;
		}
		
		
		return returnMap;
	}
	
}

