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

public class 백준_17281_야구 {
	
	public static int N, nowTaja,out=0,score=0, max= Integer.MIN_VALUE;
	public static int[][] hit;
	public static int[] permutation;
	public static boolean[] visit, ground;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_17281.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine());
		hit = new int[N][10];
		visit = new boolean[10];
		permutation = new int[10];
		ground = new boolean[4];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= 9 ; j ++) {
				hit[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		permutation[4] = 1;
		visit[4] = true;
		setTheOrder(2);
		System.out.println(max);
		
	}


	private static void setTheOrder(int count) {
		
		if(count == 10) {
			max = Math.max(max, game());
			return;
		}

		
		for(int i = 1 ; i < 10 ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				permutation[i] = count;
				setTheOrder(count+1);
				visit[i] = false; 
			}
		}
		
	}


	private static int game() {
		score = 0;
		nowTaja = 1;
		
		for(int i = 0 ; i < N; i ++) {
			out = 0;
			ground = new boolean[4];
			while(true) {
				hitAndRun(hit[i][permutation[nowTaja]]);
				nowTaja++;
				if(nowTaja == 10) {
					nowTaja = 1;
				}
				if(out==3) {
					break;
				}
			}
		}
		return score;
	}


	private static void hitAndRun(int taSu) {
		if(taSu == 0) {
			out++;
		}else if(taSu == 1) {
			for(int i = 3 ; i >= 1 ; i --) {
				if(i == 3) {
					if(ground[i]) {
						score++;
						ground[i] = false;
					}
				}else {
					if(ground[i]) {
						ground[i] = false;
						ground[i+1] = true;
					}
				}
			}
			ground[1] = true;
		}else if(taSu == 2) {
			for(int i = 3 ; i >= 1 ; i --) {
				if(i == 1 && ground[i]) {
					ground[i] = false;
					ground[i+2] = true;
				}else if( i != 1 && ground[i]) {
					ground[i] = false;
					score++;
				}
			}
			ground[2] = true;
		}else if(taSu == 3) {
			for(int i = 3 ; i >= 1 ; i --) {
				if(ground[i]) {
					ground[i] = false;
					score++;
				}
			}
			ground[3] = true;
		}else {
			for(int i = 1 ; i <= 3 ; i ++) {
				if(ground[i]) {
					score++;
					ground[i] = false;
				}
			}
			score++;
		}
		
	}


	

}

