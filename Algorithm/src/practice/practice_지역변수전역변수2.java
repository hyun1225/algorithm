package practice;

public class practice_지역변수전역변수2 {

	public static int n = 10;
	public static void main(String[] args) {
		
		func(n);
		System.out.println(n);

	}
	private static void func(int n2) {
		n2 += 100;
		n += 1;
		
	}

}
