package sw_expert_academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1954_달팽이숫자 {
	
	public static int N;
	public static int[][] snail;
	public static int[] dx = {0,0,1,0,-1};
	public static int[] dy = {0,1,0,-1,0};
	public static int cnt;
	public static boolean[][] visit;
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("swExpertInput/swExpertInput_1954.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			snail = new int[N][N];
			visit = new boolean[N][N];
			int x = 0 ;
			int y = 0 ;
			snail[0][0] = 1;
			visit[0][0] = true;
			cnt = 1;
			
			for(int i = 2; i <= N*N ; i ++) {
				
			    int nx = x+dx[cnt];
				int ny = y+dy[cnt];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || visit[nx][ny]) {
					cnt ++;
					if(cnt == 5) {
						cnt = 1;
					}
					x = x+dx[cnt];
					y = y+dy[cnt];
				}else {
					x = nx;
					y = ny;
				}
				
				snail[x][y] = i ;
				visit[x][y] = true;
			}
			
			System.out.print("#" + test_case);
			for(int i = 0 ; i < N ; i ++) {
				System.out.println();
				for(int j = 0 ; j < N ; j ++){
					System.out.print(snail[i][j] + " ");
				}
			}
			System.out.println();
			
		}

	}

}
