package heapsort;

import java.util.Arrays;

public class HeapSort {
	private int[] A;
	private int heapsize;
	
	public int getParent(int i){return (i-1)/2;}
	public int getLeft(int i){return 2*i+1;}
	public int getRight(int i){return 2*i+2;}
	
	public void maxHeapfy(int i){
		int l = getLeft(i);
		int r = getRight(i);
		int largest = i;
		if((l<=heapsize-1)&&(A[l]>A[i])){
			largest = l;
		}
		if((r<=heapsize-1)&&(A[r]>A[largest])){
			largest = r;
		}
		if(largest != i){
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			maxHeapfy(largest);
		}
	}
	
	public void buildMaxHeap(int a[]){
		this.A = a;
		this.heapsize = a.length;
		
		//寻找最后一个有子节点的节点
		for(int i = getParent(heapsize-1);i>=0; i--){
			maxHeapfy(i);
		}
	}
	
	public void heapSort(int []a){
		buildMaxHeap(a);
		int step = 1;
		for(int i=A.length-1;i>0;i--){
			System.out.println("Step: " + (step++) + Arrays.toString(A));
			int temp = A[i];
			A[i] = A[0];
			A[0] = temp;
			heapsize--;
			
			maxHeapfy(0);
		}
	}
	
	
	public static void main(String[] args) {
		    int [] A = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
		    System.out.println("Input: " + Arrays.toString(A));
		    HeapSort maxhp = new HeapSort();
//		    maxhp.buildMaxHeap(A);
//		    System.out.println(Arrays.toString(A));
		    maxhp.heapSort(A);
		    System.out.println("Output: " + Arrays.toString(A));


	}

}
