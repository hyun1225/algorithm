package baekJoon.삼성기출;

import java.util.ArrayList;
import java.util.LinkedList;
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

public class 백준_3190_뱀_ver2 {
	
	static int n, appleCnt, directCnt ;
	static Queue<int[]> snakeBody ;
//	static ArrayList<direcInfo> directList ;
	static int snakeDirection = 1;
	static int[][] map ;
	static int[] snakeHead = {0,0,1};
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int answer = 0;
	static char[] dir =  new char[10001] ;
	
	static class direcInfo{
		int time;
		String direction;
		
		direcInfo(int time, String direction){
			this.time = time;
			this.direction = direction;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/백준input3190.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		appleCnt = sc.nextInt();
		snakeBody = new LinkedList<>();
	//	directList = new ArrayList<>();
		
		snakeBody.offer(new int[]{0,0});
		map[0][0] = 2;
		
		for(int i = 0 ; i < appleCnt; i ++) {
			int row = sc.nextInt()-1;
			int col = sc.nextInt()-1;
			map[row][col] = 1;
		}
		
		directCnt = sc.nextInt();
		for(int i = 0 ; i < directCnt; i ++) {
			int idx = sc.nextInt();
			//char tmp = sc.next().charAt(0);
			char tmp = sc.next().charAt(0);
			dir[idx] = tmp;
		}
		
		
		
		while(true) {
			int nx = snakeHead[0] + dx[snakeHead[2]];
			int ny = snakeHead[1] + dy[snakeHead[2]];
			answer++;
			
			if(nx >= n || nx < 0 || ny >= n || ny <0) break;
			if(map[nx][ny] == 2) break;
			
			snakeBody.offer(new int[]{nx,ny});
			snakeHead[0] = nx;
			snakeHead[1] = ny;
			
			if(map[nx][ny] == 1) {
				map[nx][ny] = 2;
			}else {
				map[nx][ny] = 2;
				int[] tmp = snakeBody.poll();
				map[tmp[0]][tmp[1]] = 0;
			}
			
			
			if(dir[answer] == 'L' || dir[answer] == 'D') {
				chanegeDirect(dir[answer]);
			}
			
			
			
			
		}
		
		System.out.println(answer);
		
	}

	private static void chanegeDirect(char direction) {
		if(direction == 'L') {
			if(snakeHead[2] == 0) {
				snakeHead[2] = 3;
			}else {
				snakeHead[2] --;
			}
		}else {
			if(snakeHead[2] == 3) {
				snakeHead[2] = 0;
			}else {
				snakeHead[2] ++;
			}
		}
		
	}

}



