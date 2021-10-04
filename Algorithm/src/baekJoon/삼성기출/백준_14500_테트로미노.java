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

public class 백준_14500_테트로미노 {
	
	static int N,M;
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static int[][][] tetromino = { 
									{ {0,0}, {0,1}, {0,2}, {0,3} }, 
									{ {0,0}, {0,1}, {1,0}, {1,1} }, 
									{ {0,0}, {1,0}, {2,0}, {2,1} }, 
									{ {0,0}, {1,0}, {1,1}, {2,1} }, 
									{ {0,0}, {0,1}, {0,2}, {1,1} },
									{ {0,0}, {1,0}, {2,0}, {3,0} },
									{ {0,0}, {0,1}, {0,2}, {1,0} },
									{ {0,0}, {0,1}, {1,1}, {2,1} },
									{ {0,0}, {0,1}, {0,2}, {-1,2} },
									{ {0,0}, {1,0}, {2,0}, {2,-1} },
									{ {0,0}, {0,1}, {1,0}, {2,0} },
									{ {0,0}, {1,0}, {1,1}, {1,2} },
									{ {0,0}, {0,1}, {0,2}, {1,2} },
									{ {0,0}, {1,0}, {2,0}, {1,-1} },
									{ {0,0}, {1,0}, {1,-1}, {1,1} },
									{ {0,0}, {1,0}, {1,1}, {2,0} },
									{ {0,0}, {0,1}, {1,0}, {1,-1} },
									{ {0,0}, {0,1}, {1,1}, {1,2} },
									{ {0,0}, {1,0}, {1,-1}, {2,-1} },
								  };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_14500.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
				sumCheck(i,j);
			}
		}
		
		System.out.println(max);
	}

	private static void sumCheck(int row, int col) {
		
		for(int i = 0 ; i < tetromino.length; i ++) {
			int sum = 0;
			for(int j = 0 ; j < tetromino[0].length; j ++) {
				int nx = row + tetromino[i][j][0];
				int ny = col + tetromino[i][j][1];
				if(nx >= N || nx < 0 || ny >= M || ny < 0) {
					sum = -1;
					break;
				}
				sum += map[nx][ny];
			}
			if(sum > 0) {
				max = Math.max(max, sum);
			}
		}
		
	}

}

