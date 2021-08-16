package baekJoon.삼성기출;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class 백준_12100_2048Easy_ver3 {
	
	public static int N;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_12100.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//answer = Math.max(map[i][j], answer);
			}
		}
		
		game(map, 0);
		System.out.println(answer);
		
	}
	
	private static void game(int[][] map, int cnt) {
		if(cnt == 5) {
			return;
		}
		game(move("up", map), cnt+1);
		game(move("down", map), cnt+1);
		game(move("left", map), cnt+1);
		game(move("right", map), cnt+1);
	}

	private static int[][] move(String direction, int[][] map) {
		int[][] returnMap = new int[N][N];
		Stack<Integer> stack = new Stack<>();
		boolean flag = true;
		
		switch(direction) {
		
			case "up":
				for(int j = 0 ; j < N ; j ++) {
					for(int i = 0 ; i < N ; i ++) {
						if(map[i][j] != 0) {
							if(stack.size() == 0) {
								stack.add(map[i][j]);
								answer = Math.max(stack.peek(), answer);
							}else {
								if(stack.peek() == map[i][j] && flag) {
									stack.add(stack.pop()*2);
									flag = false;
									answer = Math.max(stack.peek(), answer);
									continue;
								}else {
									stack.add(map[i][j]);
									answer = Math.max(stack.peek(), answer);
								}
							}
							flag = true;
						}
					}
					
					while(!stack.isEmpty()) {
						int i = stack.size()-1;
						returnMap[i][j] = stack.pop();
					}
					stack.clear();
				}
				break;
				
			case "down":
				for(int j = 0 ; j < N ; j ++) {
					for(int i = N-1 ; i >= 0 ; i --) {
						if(map[i][j] != 0) {
							if(stack.size() == 0) {
								stack.add(map[i][j]);
								answer = Math.max(stack.peek(), answer);
							}else {
								if(stack.peek() == map[i][j] && flag) {
									stack.add(stack.pop()*2);
									flag = false;
									answer = Math.max(stack.peek(), answer);
									continue;
								}else {
									stack.add(map[i][j]);
									answer = Math.max(stack.peek(), answer);
								}
							}
							flag = true;
						}
					}
					
					while(!stack.isEmpty()) {
						int i = N - stack.size();
						returnMap[i][j] = stack.pop();
					}
					stack.clear();
				}
				break;
				
			case "left":
				for(int i = 0 ; i < N ; i ++) {
					for(int j = 0 ; j < N ; j ++) {
						if(map[i][j] != 0) {
							if(stack.size() == 0) {
								stack.add(map[i][j]);
								answer = Math.max(stack.peek(), answer);
							}else {
								if(stack.peek() == map[i][j] && flag) {
									stack.add(stack.pop()*2);
									flag = false;
									answer = Math.max(stack.peek(), answer);
									continue;
								}else {
									stack.add(map[i][j]);
									answer = Math.max(stack.peek(), answer);
								}
							}
							flag = true;
						}
					}
					
					while(!stack.isEmpty()) {
						int j = stack.size() - 1 ;
						returnMap[i][j] = stack.pop();
					}
					stack.clear();
				}
				break;
				
			case "right":
				for(int i = 0 ; i < N ; i ++) {
					for(int j = N-1 ; j >= 0 ; j --) {
						if(map[i][j] != 0) {
							if(stack.size() == 0) {
								stack.add(map[i][j]);
								answer = Math.max(stack.peek(), answer);
							}else {
								if(stack.peek() == map[i][j] && flag) {
									stack.add(stack.pop()*2);
									flag = false;
									answer = Math.max(stack.peek(), answer);
									continue;
								}else {
									stack.add(map[i][j]);
									answer = Math.max(stack.peek(), answer);
								}
							}
							flag = true;
						}
					}
					
					while(!stack.isEmpty()) {
						int j = N - stack.size() ;
						returnMap[i][j] = stack.pop();
					}
					stack.clear();
				}
				break;
		
		}
		
		return returnMap;
	}
	

	
	
}

