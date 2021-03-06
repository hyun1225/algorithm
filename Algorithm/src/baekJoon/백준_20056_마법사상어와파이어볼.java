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

public class 백준_20056_마법사상어와파이어볼 {
	
	//ArrayList를 LikedList 로 변경시 속도 느림
	//for문 처럼 index를 돌때는 ArrayList 가 빠름 
	public static int N,M,K,answer=0;
	public static ArrayList<int[]> fireball;
	public static ArrayList<int[]> newFireball;
	public static ArrayList<int[]>[][] map;
	public static int[] dx = {0,1,1,1,0,-1,-1,-1};	
	public static int[] dy = {-1,-1,0,1,1,1,0,-1};	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_20056.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		fireball = new ArrayList<>();
		map = new ArrayList[N][N];
		
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			fireball.add(new int[] {r,c,weight,speed,direction});
			
			/*
			fireball.add(new int[] {Integer.parseInt(st.nextToken())-1
								   ,Integer.parseInt(st.nextToken())-1
								   ,Integer.parseInt(st.nextToken())
								   ,Integer.parseInt(st.nextToken())
								   ,Integer.parseInt(st.nextToken())
								   });
			 */
		}
		
		while(K>0) {
			init();
			move();
			fireballSpread();
			K--;
		}
		
		for(int i = 0 ; i < fireball.size(); i ++) {
			answer += fireball.get(i)[2];
		}
		System.out.println(answer);
		
	}

	private static void fireballSpread() {
		
		newFireball = new ArrayList<>();
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j].size() >= 2) {
					spread(map[i][j]);
				}else if(map[i][j].size() == 1) {
					newFireball.add(map[i][j].get(0));
				}
			}
		}
		fireball = newFireball;
	}

	private static void spread(ArrayList<int[]> arrayList) {
		int spreadM = 0;
		int spreadS = 0;
		boolean flag = false;
		int zzagCnt = 0;
		
		for(int i = 0 ; i < arrayList.size(); i ++) {
			int[] tmp = arrayList.get(i);
			spreadM += tmp[2];
			spreadS += tmp[3];
			if(tmp[4]%2 == 0) zzagCnt++;
		}
		if(zzagCnt == arrayList.size() ||zzagCnt == 0) {
			flag = true;
		}
		spreadM /= 5;
		spreadS /= arrayList.size();
		
		if(spreadM != 0) {
			int k = 0;
			if(!flag) {
				k=1;
			}
			for(int i = 0 ; i< 4 ; i ++) {
				int r = arrayList.get(0)[0];
				int c = arrayList.get(0)[1];
				newFireball.add(new int[] {r,c,spreadM,spreadS,k});
				k+=2;
			}
		}
		
		
	}

	private static void move() {
		for(int i = 0 ; i < fireball.size(); i++) {
			int[] fireTmp = fireball.get(i);
			int nx = fireTmp[1] + dx[fireTmp[4]] * (fireTmp[3]%N);
			int ny = fireTmp[0] + dy[fireTmp[4]] * (fireTmp[3]%N);
			if(nx >=N ) nx-=N;
			else if(nx < 0) nx+=N;
			if(ny >= N) ny-=N;
			else if(ny < 0) ny+=N;
			
			fireTmp[1] = nx ;
			fireTmp[0] = ny ;
			map[ny][nx].add(fireTmp);
		}
	}

	private static void init() {
		map = new ArrayList[N][N];
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = new ArrayList<>();
			}
		}
	}

}

