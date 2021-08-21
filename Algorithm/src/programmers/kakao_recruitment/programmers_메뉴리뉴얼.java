package programmers.kakao_recruitment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

public class programmers_메뉴리뉴얼 {
	

	static List<String> answer, tempList;
	static int max = Integer.MIN_VALUE; 
	static String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
	static int[] course = {2, 3, 5};
		
	/*
	 * 테스트케이스1
	 *  {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
	 *  {2, 3, 4};
	 * */

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/programmers_input/programmers_input_.txt"));

		answer = new ArrayList<>();

		
		for(int i = 0 ; i < course.length; i ++) {
			max = Integer.MIN_VALUE; 
			tempList = new ArrayList<>();
			menuCombinationSelect(course[i], 0, 'A'-0, "");
			answer.addAll(tempList);
		}
		
		Collections.sort(answer);
		String[] aaaa = {};
		aaaa = answer.toArray(new String[answer.size()]);
		//System.out.println(aaaa);
		System.out.println(answer);
		
	}
	
	private static void menuCombinationSelect(int menuCnt, int selectCnt, int start, String menu) {
		
		if(selectCnt == menuCnt) {
			menuCheck(menu);
			return;
		}
		
		for(int i = start ; i <= 'Z'-0 ; i ++ ) {
			String m = Character.toString((char)i);
			menuCombinationSelect(menuCnt, selectCnt+1, i+1, menu+m);
		}
		
		
	}
	
	private static void menuCheck(String menu) {
		int cnt = 0;
		for(int i = 0 ; i < orders.length ; i ++) {
			boolean flag = true;
			
			for(int j = 0 ; j < menu.length() ; j ++) {
				if(orders[i].indexOf(menu.charAt(j)) < 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt ++;
			}
		}
		if(cnt >= 2) {
			if(cnt == max) {
				tempList.add(menu);
			}else if(cnt > max) {
				max = cnt;
				tempList = new ArrayList<>();
				tempList.add(menu);
			}
		}
	}

}

