package programmers.kakao_recruitment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
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

public class programmers_메뉴리뉴얼_ver2 {
	

; 
	static String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
	static int[] course = {2, 3, 5};
	static HashMap<String,Integer> map;
	static int m;
	/*
	 * 테스트케이스1
	 *  {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
	 *  {2, 3, 4};
	 * */

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/programmers_input/programmers_input_.txt"));

		PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i=0;i<course.length;i++){
            map = new HashMap<>();
            m=0;
            for (int j=0;j<orders.length;j++) {
                find(0, "", course[i], 0, orders[j]);
            }
            for (String s : map.keySet()){
                if (map.get(s)==m && m>1){
                    pq.offer(s);
                }
            }
        }
        String  ans[] = new String[pq.size()];
        int k=0;
        System.out.println(pq);
        while (!pq.isEmpty()){
            ans[k++] = pq.poll();
        }
        
		
	}
	
	 static void find(int cnt, String str, int targetNum, int idx, String word){
	        if (cnt==targetNum){
	            char[] c = str.toCharArray();
	            Arrays.sort(c);
	            String temps="";
	            for (int i=0;i<c.length;i++) {
	            	temps+=c[i];
	            }
	            map.put(temps,map.getOrDefault(temps,0)+1);
	            m = Math.max(m,map.get(temps));
	            return;
	        }
	        for (int i=idx; i<word.length(); i++){
	            char now =word.charAt(i);
	            find(cnt+1,str+now,targetNum,i+1,word);
	        }
	    }

}

