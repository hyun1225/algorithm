package practice;

import java.util.ArrayList;
import java.util.List;

public class practice_인자로배열등등넘겨준후계싼 {

	public static void main(String[] args) {
		
		int n = 10;
		List<fish> list = new ArrayList<>();
		list.add(new fish(1,2));
		fish f = new fish(10,11);
		int[][] map = new int[2][2];
		map[0][0] = 1;
	
		System.out.println("n값 변경 전  : "+n);
		System.out.println("list.get(0).x 값 변경 전  : " + list.get(0).x);
		System.out.println("리스트 주소값? : "+list);
		System.out.println("f.x 변경 전 : " + f.x);
		System.out.println("map[0][0] 변경 전 : " + map[0][0]);
		
		func(n, list, f, map);
		
		System.out.println();
		System.out.println("n값 변경 후 : "+n);
		System.out.println("list.get(0).x 값 변경 후 : " + list.get(0).x);
		System.out.println("리스트 주소값? : "+list);
		System.out.println("f.x 변경 후  : " + f.x);
		System.out.println("map[0][0] 변경 후  : " + map[0][0]);

	}

	private static void func(int n, List<fish> list, fish f, int[][] map) {
		
		n+=10;
		list.get(0).x = 100;
		f.x += 1000;
		map[0][0] += 90;
	}
	private static class fish{
		int x;
		int y;
		fish(int x, int y){
			this.x=x;
			this.y=y;
		}
	}

}

