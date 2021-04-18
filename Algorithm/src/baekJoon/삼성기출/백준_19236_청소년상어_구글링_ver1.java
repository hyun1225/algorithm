package baekJoon.삼성기출;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
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

public class 백준_19236_청소년상어_구글링_ver1 {

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int maxSum = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/백준input_19236.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[4][4];
		List<Fish> fishes = new ArrayList<>();

		// input
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 4; j++) {
				Fish f = new Fish();
				f.id = Integer.parseInt(st.nextToken());
				f.dir = Integer.parseInt(st.nextToken()) - 1;
				f.x = i;
				f.y = j;

				fishes.add(f);
				arr[i][j] = f.id;
			}
		}
		
		Collections.sort(fishes, new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				return o1.id - o2.id;
			}
		});
		
		 // 상어는 (0, 0) 물고기를 먹고 시작하며 위치는 -1 로 표현
        Fish f = fishes.get(arr[0][0] - 1);
        Shark shark = new Shark(0, 0, f.dir, f.id);
        f.isAlive = false;
        arr[0][0] = -1;
        
        // solution
        dfs(arr, shark, fishes);
        System.out.println(maxSum);
		

	}

	private static void dfs(int[][] arr, Shark shark, List<Fish> fishes) {
		if (maxSum < shark.eatSum) {
            maxSum = shark.eatSum;
        }

        // 모든 물고기 순서대로 이동
        fishes.forEach(e -> moveFish(e, arr, fishes));
        
        for (int dist = 1; dist < 4; dist++) {
            int nx = shark.x + dx[shark.dir] * dist;
            int ny = shark.y + dy[shark.dir] * dist;
    
            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && arr[nx][ny] > 0) {
                // 물고기 잡아먹고 dfs
                int[][] arrCopies = copyArr(arr);
                List<Fish> fishCopies = copyFishes(fishes);
                
                arrCopies[shark.x][shark.y] = 0;
                Fish f = fishCopies.get(arr[nx][ny] - 1);
                Shark newShark = new Shark(f.x, f.y, f.dir, shark.eatSum + f.id);
                f.isAlive = false;
                arrCopies[f.x][f.y] = -1;
                
                dfs(arrCopies, newShark, fishCopies);
            }
        }
		
	}
	
	// 이동가능한 칸은 빈칸, 다른 물고기가 있는 칸
    // 45도 반시계 방향으로 회전하면서 스캔
    static void moveFish(Fish fish, int[][] arr, List<Fish> fishes) {
        if (fish.isAlive == false) return;

        for (int i = 0; i < 8; i++) {
            int nextDir = (fish.dir + i) % 8;
            int nx = fish.x + dx[nextDir];
            int ny = fish.y + dy[nextDir];

            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && arr[nx][ny] > -1) {
                arr[fish.x][fish.y] = 0;
                
                if (arr[nx][ny] == 0) {
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    Fish temp = fishes.get(arr[nx][ny] - 1);
                    temp.x = fish.x;
                    temp.y = fish.y;
                    arr[fish.x][fish.y] = temp.id;

                    fish.x = nx;
                    fish.y = ny;
                }

                arr[nx][ny] = fish.id;
                fish.dir = nextDir;
                return;
            }
        }
    }

    static int[][] copyArr(int[][] arr) {
        int[][] temp = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = arr[i][j];
            }
        }

        return temp;
    }

    static List<Fish> copyFishes(List<Fish> fishes) {
        List<Fish> temp = new ArrayList<>();
        fishes.forEach(e -> temp.add(new Fish(e.x, e.y, e.id, e.dir, e.isAlive)));
        return temp;
    }

	static class Shark {
		int x, y, dir, eatSum;

		Shark() {
		}

		Shark(int x, int y, int dir, int eatSum) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.eatSum = eatSum;
		}
	}

	static class Fish {
		int x, y, id, dir;
		boolean isAlive = true;

		Fish() {
		}

		Fish(int x, int y, int id, int dir, boolean isAlive) {
			this.x = x;
			this.y = y;
			this.id = id;
			this.dir = dir;
			this.isAlive = isAlive;
		}
	}

}



