package sw_expert_academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_2072 {
	
	public static int tmp, answer;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("swExpertInput/swExpertInput_2072.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer = 0;
			tmp = 0;
			for(int i = 0 ; i < 10 ; i ++) {
				tmp = sc.nextInt();
				if(tmp%2 == 1) {
					answer += tmp;
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}

	}

}
