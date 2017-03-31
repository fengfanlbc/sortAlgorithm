package search.searchTree;

import java.util.Arrays;

import heapsort.HeapSort;
import mergesort.MergeSort;

public class FindMidnum {

	private int[] a;
	private int size;
	public int getParent(int i){return (i-1)/2;}
	public int getLeft(int i){return 2*i+1;}
	public int getRight(int i){return 2*i+2;}
	
	public static void main(String[] args) {
		int []a = {1,3,2,22,44,3,23,9,55,66,44,5,33,22,90};
		int []a2 = {1,3,2,22,44,3,23,9,55,66,44,5,33,22,90};
		long start = System.currentTimeMillis();
		FindMidnum find = new FindMidnum();
		int medium = find.fingMedium(a);
		//System.out.println(Arrays.toString(a));
		//堆顶即为中位数
		System.out.println("中位数：" + medium);
		long end = System.currentTimeMillis();
		long spend = end - start;
		System.out.println("search tree need " + spend + "ms");
		
		
		mergesort.MergeSort sort = new MergeSort();
		long start1 = System.currentTimeMillis();
		sort.mergeSort(a2);
		System.out.println(Arrays.toString(a2));
		System.out.println("中位数：" + a2[a2.length/2]);
		long end1 = System.currentTimeMillis();
		long spend1 = end1 - start1;
		System.out.println("merge sort need " + spend1 + "ms");
		
	}
	public int fingMedium(int a[]){
		int []b = new int[a.length/2];
		System.arraycopy(a, 0, b, 0, a.length/2);
		heapsort.HeapSort maxheap= new HeapSort();
		maxheap.buildMaxHeap(b);
		
		
		System.out.println("数组前半部分b堆排序后:"+Arrays.toString(b));
		for(int i=a.length/2+1;i<a.length;i++){
			if(a[i] < b[0]){
				b[0] = a[i];
				maxheap.buildMaxHeap(b);
			}
		}
		return b[0];
		
	}
	
//	public void buildSearchTree(int i){
//		int l = getLeft(i);
//		int r = getRight(i);
//		int mid = i;
//		if(l<=size&&a[l]>a[i]){
//			mid = l;
//		}
//		if(r<=size&&a[r]<a[mid]){
//			mid = r;
//		}
//		if(mid != i){
//			int temp = a[i];
//			a[i] = a[mid];
//			a[mid] = temp;
//		}
//		if(a[l]>a[r]){
//			int temp = a[l];
//			a[l] = a[r];
//			a[r] = temp;
//		}
//	}
//	
//	//构建一个二叉查找树
//	public void build(int a[]){
//		this.a = a;
//		this.size = a.length;
//		for(int i=getParent(size-1);i>=0;i--){
//			buildSearchTree(i);
//		}
//	}	

}
