package baekJoon.분할정복;

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

public class 백준_2630_색종이만들기 {
	
	public static int[][] map;
	public static int N;
	public static int[] blueWhite = new int[2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_2630.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divideAndConquer(0,0,N );
		System.out.println(blueWhite[0]);
		System.out.println(blueWhite[1]);
		
	}


	private static void divideAndConquer(int startX, int startY ,int length ) {
		if(check(startX, startY, length, map[startX][startY])) {
			blueWhite[map[startX][startY]]++;
			return;
		}
		int halfLength = length/2;
		divideAndConquer(startX, startY, halfLength);
		divideAndConquer(startX, startY+halfLength, halfLength);
		divideAndConquer(startX+halfLength, startY, halfLength);
		divideAndConquer(startX+halfLength, startY+halfLength, halfLength);
	}


	private static boolean check(int startX, int startY, int length, int firstColor) {

		for(int i = startX; i < startX + length ; i ++) {
			for(int j = startY; j < startY + length; j ++) {
				if(map[i][j] != firstColor) {
					return false;
				}
			}
		}
		return true;
	}

}

