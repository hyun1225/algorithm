package baekJoon.문자열;

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
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2941_크로아티아알파벳 {
	

	static String[] alpha = {"c=", "c-" , "dz=", "d-", "lj", "nj", "s=", "z="};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_2941.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String croatia = br.readLine();
		int answer = 0;
		
		for(int i = 0 ; i < croatia.length() ; ) {
			
			int j = 1;
			while(true) {
				
				if(j >= 3) {
					answer ++ ;
					i ++ ;
					break;
				}
				
				if( croatia.length()-1 < (i+j) ) {
					answer ++ ;
					i ++ ;
					break;
				}
				
				String tmpStr = croatia.substring(i, (i+j)+1);
				if(croatiaCheck(tmpStr)) {
					i += (j+1) ;
					answer ++ ; 
					break;
				}else {
					j++;
				}
			}
		}
		
		System.out.println(answer);
		
	}

	private static boolean croatiaCheck(String str) {
		
		for(int i = 0 ; i < alpha.length ; i ++) {
			if(alpha[i].equals(str)) {
				return true;
			}
		}
		return false;
	}

	

}

