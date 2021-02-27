package baekJoon;

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

public class 백준_1018_체스판다시칠하기_ver3 {
	
	
	static int min = Integer.MAX_VALUE;
	static boolean[][] chessBoard;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1018.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		// Scanner sc = new Scanner(System.in);
		// boolean[][] chessBoard;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		chessBoard = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			String block = br.readLine();
			for (int j = 0; j < N; j++) {
				if (block.charAt(j) == 'W') {
					chessBoard[i][j] = true;
				} else {
					chessBoard[i][j] = false;
				}
			}
		}

		int row = M - 7;
		int column = N - 7;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				countMin(i, j);
			}
		}
		System.out.println(min);
		// System.out.println(min);

	}

	

	private static void countMin(int x, int y) {
		int endOfX = x+8;
		int endOfY = y+8;
		int count = 0 ;
		
		boolean checkBlock = chessBoard[x][y];
		
		for(int i = x ; i < endOfX ; i ++) {
			for(int j = y ; j < endOfY ; j ++) {
				if(chessBoard[i][j] != checkBlock) {
					count++;
				}
				checkBlock = !checkBlock;
			}
			checkBlock = !checkBlock;
		}
		
		count = Math.min(count, 64-count);
		min = Math.min(min, count);
		
	}


	

}

