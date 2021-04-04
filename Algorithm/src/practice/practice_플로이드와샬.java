package practice;

public class practice_플로이드와샬 {
	
	static int INF = 999999;

	public static void main(String[] args) {
		
		int arr[][] = {{0,   1,    INF, 4,  5},
					  {INF,  0,    3,   2,  1},
                      {1,    INF,  0,   5,  3},
                      {INF,  INF,  4,   0,  2},
                      {4,    INF,  1,   7,  0}};
		
		for(int i = 0 ; i <arr.length;i++) { //거쳐가는점 
			for(int j = 0 ; j < arr.length ; j ++) { //시작점 
				for (int k = 0 ; k < arr.length ; k ++) { //도착점 
					int A = arr[j][k];
					int B = arr[j][i];
					int C = arr[i][k];
					if(A > B + C) {
						arr[j][k] = arr[j][i] + arr[i][k];
					}
				}
			}
		}
		
		for(int i = 0 ; i < arr.length ; i ++) {
			for(int j = 0 ; j < arr.length; j ++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		

	}

}
