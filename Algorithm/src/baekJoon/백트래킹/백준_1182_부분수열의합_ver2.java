package baekJoon.백트래킹;

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

public class 백준_1182_부분수열의합_ver2 {
	
	
	static int N, S, count=0;
    static int[] arr;


	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_1182.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		if(S==0){// count 합이 0인 경우 공집합도 포함되므로 그 수를 하나 빼주고 출력
            count--;
            System.out.println(count);
        }else {
            System.out.println(count);
        }
		
	}
	        
	
	private static void dfs(int v , int su){
        if(v==N){// dfs로 돌며 누적시키다가 위치를 나타내는 v이 마지막 위치로 오면 원하는 값인지 아닌지 체크하여 count
            if(su == S){
                count++;
            }
            return;
        }
        // 부분수열, 지금 위치의 원소를 선택하거, 선택하지 않거나
        dfs(v+1, su+arr[v]); // 지금 위치의 원소를 선택
        dfs(v+1, su); // 선택하지 않음.
    }


}

