package baekJoon.삼성기출;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
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

public class 백준_21609_상어중학교 {

	
	public static PriorityQueue<BlockGroupInfo>  q;
	public static int N,M;
	public static int rainBowCnt;
	public static List<Block> blockList;
	public static Block baseBlock;
	public static int[][] map, tmpMap;
	public static boolean[][] visit, tmpVisit;
	public static int answer = 0;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_21609.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i  ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(findBlockGroup() > 0) {
			removeBlock();
			gravity();
			rotate();
			gravity();
		}
		
		System.out.println(answer);
		
	}
	
	private static void rotate() {
		tmpMap = new int[N][N];
		
		for(int col = N-1, i = 0; col >=0 ; col --, i ++) {
			for(int row = 0 ; row < N ; row ++) {
				tmpMap[i][row] = map[row][col] ;
			}
		}
		
		map = tmpMap;
		
	}

	private static void gravity() {
		int[] baseRow = new int[N];
		for(int i = 0 ; i < N ; i ++) {
			if(map[N-1][i] >= -1) {
				baseRow[i] = N-1;
			}else {
				baseRow[i] = N;
			}
		}
		
		for(int i = N-2 ; i >=0 ; i --) {
			for(int j = 0 ; j < N ; j ++) {
				if(map[i][j] > -1) {
					int tmp = map[i][j];
					map[i][j] = -99;
					map[baseRow[j]-1][j] = tmp;
					baseRow[j] = baseRow[j] - 1 ; 
				}else if(map[i][j] == -1) {
					baseRow[j] = i;
				}
			}
		}
		
	}

	private static void removeBlock() {
		BlockGroupInfo tmpBlGrp = q.peek();
		for(int i = 0 ; i < tmpBlGrp.blockList.size(); i ++) {
			int x = tmpBlGrp.blockList.get(i).row;
			int y = tmpBlGrp.blockList.get(i).col;
			map[x][y] = -99;
		}
		//answer += Math.pow(tmpBlGrp.size, 2);
		answer += tmpBlGrp.size * tmpBlGrp.size;
	}

	private static int findBlockGroup() {
		q = new PriorityQueue<>();
		visit = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N ; j ++) {
				if(map[i][j]>0 && !visit[i][j]) {
					init();
					dfs(i,j,map[i][j]);
					if(blockList.size() >= 2) {
						q.add(new BlockGroupInfo(blockList.size(), rainBowCnt, blockList, baseBlock));
					}
				}
			}
		}
		
		return q.size();
	}

	private static void init() {
		tmpVisit = new boolean[N][N];
		rainBowCnt = 0;
		blockList = new ArrayList<>();
		baseBlock = new Block(Integer.MAX_VALUE,Integer.MAX_VALUE);
	}

	private static void dfs(int x, int y, int color) {
		if(map[x][y] > 0) {
			visit[x][y] = true;
			tmpVisit[x][y] = true;
			baseBlock = baseBlockCheck(x,y);
		}else if(map[x][y] == 0) {
			tmpVisit[x][y] = true;
			rainBowCnt++;
		}
		
		blockList.add(new Block(x,y));
		
		for(int d = 0 ; d < 4; d ++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(tmpVisit[nx][ny]) continue;
			if(map[nx][ny] == -1) continue;
			if(map[nx][ny] == -99) continue;
			if(map[nx][ny] != 0 && map[nx][ny] != color) continue;
			
			dfs(nx,ny,color);
		}
		
	}

	private static Block baseBlockCheck(int x, int y) {
		if(baseBlock.row > x) {
			baseBlock.row = x;
			baseBlock.col = y;
		}else if(baseBlock.row == x) {
			if(baseBlock.col > y) {
				baseBlock.row = x;
				baseBlock.col = y;
			}
		}
		return baseBlock;
	}

	static class BlockGroupInfo implements Comparable<BlockGroupInfo>{
		int size;
		int rainBowBlockCnt;
		List<Block> blockList;
		Block baseBlock;
		
		BlockGroupInfo(int size, int rainBowBlockCnt, List<Block> blockList, Block baseBlock){
			this.size = size;
			this.rainBowBlockCnt = rainBowBlockCnt;
			this.blockList = blockList;
			this.baseBlock = baseBlock;
		}

		public int compareTo(BlockGroupInfo b) {
			if(this.size < b.size) {
				return 1;
			}else if(this.size == b.size) {
				if(this.rainBowBlockCnt < b.rainBowBlockCnt) {
					return 1;
				}else if(this.rainBowBlockCnt == b.rainBowBlockCnt) {
					if(this.baseBlock.row < b.baseBlock.row) {
						return 1;
					}else if(this.baseBlock.row == b.baseBlock.row) {
						if(this.baseBlock.col < b.baseBlock.col) {
							return 1;
						}
					}
				}
			}
			return -1;
		}
	}
	
	static class Block{
		int row;
		int col;
		
		Block(int row, int col){
			this.row = row;
			this.col = col;
		}
	}

}