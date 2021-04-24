package programmers.Level1;

import java.util.*;

public class programmers_Level1_크레인인형뽑기 {

	public static Stack<Integer> stack = new Stack<>();
	public static int[] check;

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		check = new int[board[0].length];

		for (int i = 0; i < moves.length; i++) {
			int col = moves[i] - 1;
			for (int row = check[col]; row < board[0].length; row++) {
				// if(row >= board[0].length) break;
				if (board[row][col] != 0) {
					if (!stack.isEmpty() && stack.peek() == board[row][col]) {
						stack.pop();
						answer += 2;
					} else {
						stack.push(board[row][col]);
					}
					board[row][col] = 0;
					check[col]++;
					break;
				}
				if (row == board[0].length - 1) {
					check[col] = board[0].length;
				}
			}
		}

		return answer;
	}

}
