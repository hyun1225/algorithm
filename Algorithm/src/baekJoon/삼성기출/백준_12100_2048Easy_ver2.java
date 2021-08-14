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
	static int[][] map ;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_12100.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		game(0);
		System.out.println(max);
		
	}
	
	public static void game(int cnt) {
		if(cnt == 5) {
			//findMax();
			return;
		}
		
		int[][] copy = new int[N][N];
		for(int i = 0 ; i < N ; i ++) {
			copy[i] = map[i].clone();
		}
		
		for(int i = 0 ; i < 4 ; i ++) {
			move(i);
			game(cnt+1);
			for(int k = 0 ; k < N ; k ++) {
				map[k] = copy[k].clone();
			}
		}
		
	}
	
	/*
	public static void findMax() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                max = Math.max(max, map[i][j]);
    }
    */

	private static void move(int direction) {
		
		switch(direction) {
			case 0:
				//위
				for(int col = 0 ; col < N ; col++) {
					int value = 0;
					int index = 0;
					for(int row = 0 ; row < N ; row ++) {
						if(map[row][col] != 0) {
							if(value == map[row][col]) {
								map[index-1][col] = value * 2;
								value = 0;
								map[row][col]=0;
								max = Math.max(map[index-1][col], max);
							}else {
								value = map[row][col];
								map[row][col] = 0;
								map[index][col] = value;
								max = Math.max(map[index][col], max);
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
								map[index+1][col] = value * 2;
								value = 0;
								map[row][col]=0;
								max = Math.max(map[index+1][col], max);
							}else {
								value = map[row][col];
								map[row][col] = 0;
								map[index][col] = value;
								max = Math.max(map[index][col], max);
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
								map[row][index-1] = value * 2;
								value = 0;
								map[row][col]=0;
								max = Math.max(map[row][index-1], max);
							}else {
								value = map[row][col];
								map[row][col] = 0;
								map[row][index] = value;
								max = Math.max(map[row][index], max);
								index++;
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
								map[row][index+1] = value * 2;
								value = 0;
								map[row][col]=0;
								max = Math.max(map[row][index+1], max);
							}else {
								value = map[row][col];
								map[row][col] = 0;
								map[row][index] = value;
								max = Math.max(map[row][index], max);
								index--;
							}
						}
					}
				}
				break;
		}
	}
	
}

