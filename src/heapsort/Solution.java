package heapsort;
import java.util.*;
public class Solution {
    public int length ;
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        length = input.length;
        ArrayList<Integer> list = new ArrayList();
        if(length<k)return list;
        getMinHeap(input);
        for(int i=0; i<k; i++){
            list.add(input[0]);
            int temp = input[0];
            input[0] = input[length-1];
            input[length-1] = temp;
            length--;
            minHeapfy(input,0);
        }
        return list;
    }
    public void getMinHeap(int a[]){
        for(int i=(length)/2;i>=0;i--){
            minHeapfy(a,i);
        }
    }
    public void minHeapfy(int[]a, int i){
        int left = i*2 + 1;
        int right = i*2 + 2;
        int min = i;
        if((left<=length-1)&&a[left] < a[i]){
           min = left; 
        }
        if((right <= length-1) && a[right] < a[min]){
            min = right;
        }
        if(min != i){
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
            minHeapfy(a,min);
        }
    }
}