package baekJoon.백트래킹;

import java.util.*;
import java.io.*;


public class 백준_2529_부등호 {
	
	public static int k ;
	public static char[] arr;
	public static boolean[] visit;
	public static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/백준input_2529.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		arr = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < k ;i ++) {
			arr[i] = st.nextToken().charAt(0);
		}
		visit = new boolean[10];
		select(0,"");
		
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
		
	}

	private static void select(int cnt, String num) {
		
		if(cnt == k+1) {
			list.add(num);
			return;
		}
		
		for(int i = 0 ; i <= 9; i ++) {
			if(visit[i]) continue;
			if(cnt == 0 || check(Character.getNumericValue(num.charAt(cnt-1)), i, arr[cnt-1])) {
				visit[i] = true;
				select(cnt+1, num+i);
				visit[i] = false;
			}
		}
		
	}

	private static boolean check(int a, int b, char c) {
		if(c == '>') {
			if(a < b) {
				return false;
			}
		} else {
			if(a>b) {
				return false;
			}
		}
		return true;
	}

	

	

}

