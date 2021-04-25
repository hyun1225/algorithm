package baekJoon.이분탐색;
import java.util.*;




import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Scanner;
//a = sc.nextInt();                           // int 변수 1개 입력받는 예제
//b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
//g = sc.nextByte();                          // char 변수 1개 입력받는 예제
//var = sc.next();                            // 문자열 1개 입력받는 예제
//AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
import java.io.*;

public class 백준_1920_수찾기 {
	

	public static int N,M;
	public static int[] nums;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_1920.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i ++) {
			int a = Integer.parseInt(st.nextToken());
			if(binarySearch(a)) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
		}
		
		System.out.println(sb);
		
	}

	private static boolean binarySearch(int findValue) {
		int leftIndex = 0;
		int rightIndex = N-1;
		while(leftIndex <= rightIndex) {
			int midIndex = (leftIndex + rightIndex) / 2;
			int midValue = nums[midIndex];
			if( midValue > findValue) {
				rightIndex = midIndex -1;
			}else if(midValue < findValue) {
				leftIndex = midIndex +1;
			}else {
				return true;
			}
		}
		return false;
	}

}

