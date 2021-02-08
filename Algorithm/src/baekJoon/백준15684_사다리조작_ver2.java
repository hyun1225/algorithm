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

public class 백준15684_사다리조작_ver2 {
	
	private static int n, m, h, answer;
    private static int[][] map;
    private static boolean finish = false;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input15684.txt"));

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        n = Integer.parseInt(st.nextToken());
	        m = Integer.parseInt(st.nextToken());
	        h = Integer.parseInt(st.nextToken());

	        map = new int[h + 1][n + 1];

	        int x, y;
	        for (int i = 0; i < m; i++) {
	            st = new StringTokenizer(br.readLine());
	            x = Integer.parseInt(st.nextToken());
	            y = Integer.parseInt(st.nextToken());
	            map[x][y] = 1;
	            map[x][y + 1] = 2;
	        }

	      for(int i = 0 ; i <=3 ; i ++) {
	    	  answer = i;
	    	  dfs(1,0);
	    	  if(finish) {
	    		  break;
	    	  }
	      }
	       
	      System.out.println((finish)? answer : -1);
	      
		
	}

	private static void dfs(int x , int count) {
		if(finish) {
			return;
		}
		if(answer == count) {
			if(check()) {
				finish = true;
			}
			return;
		}
		
		for(int i = x; i  < h+1 ; i++) {
			for(int j = 1 ; j < n ; j ++) {
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					map[i][j] = 1;
					map[i][j+1] = 2;
					dfs(i,count + 1);
					map[i][j] = 0;
					map[i][j+1] = 0;
				}
			}
		}
		
	}

	private static boolean check() {
		for(int i = 1 ; i <=n ; i ++) {
			int x = 1;
			int y = i;
			for(int j = 0 ; j < h ; j ++) {
				if(map[x][y] == 1) {
					y ++;
				}else if(map[x][y] == 2) {
					y --;
				}
				x++;
			}
			if(y != i) {
				return false;
			}
			
		}
		return true;
	}
	


}

