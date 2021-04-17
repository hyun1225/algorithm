package practice;

import java.util.Arrays;

public class practice_분할정복_합병정렬 {

	public static int[] src;
	public static int[] tmp;
	
	
	public static void main(String[] args) {
		
		src = new int[] {15,5,9,7};
		tmp = new int[src.length];
		System.out.println(Arrays.toString(src));
		mergeSort(0,src.length-1);
		System.out.println(Arrays.toString(src));
		

	}


	private static void mergeSort(int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			
			int p = start;
			int q = mid + 1;
			int idx = p;
			
			while(p <= mid || q <= end) {
				if( q>end || (p<=mid && src[p]<=src[q])) {
					tmp[idx++] = src[p++];
				}else {
					tmp[idx++] = src[q++];
				}
			}
			
			for(int i = start ; i <=end; i ++) {
				src[i] = tmp[i];
			}
		}
	}

}
