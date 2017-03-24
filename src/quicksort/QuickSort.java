package quicksort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int a[] = {48,6,57,88,60,42,83,73,72,85};
		QuickSort sort = new QuickSort();
		System.out.println("before quicksort :" + Arrays.toString(a));
		sort.quickSort(a);
		System.out.println("after quicksort :" + Arrays.toString(a));

	}
	
	public void quickSort(int a[]){
		quickSort(a,0,a.length-1);
	}
	
	public void quickSort(int[]a, int left, int right){
		if(left<right){
			int i = left;
			int j = right;
			//获得基准数，可以理解为把数给挖出来了，现在要填补它
			int x = a[left];
			//根据基准数的一次遍历
			while(i<j){
				//从后往前比较，找到填充数
				while(i<j&&a[j]>=x){
					j--;
				}
				if(i<j){
					a[i] = a[j];
				}
				//从前往后比较，找到填充树
				while(i<j&&a[i]<=x){
					i++;
				}
				if(i<j)
					a[j] = a[i];
			}
			a[i] = x;
			//对基准数左边的区域做快排
			quickSort(a, left, i-1);
			quickSort(a, i+1, right);
		}
	}

}
