package mergesort;

public class FindInversePairs {

	public static void main(String[] args) {
		FindInversePairs f = new FindInversePairs();
		int num = f.InversePairs(new int[]{1,2,3,4,5,6,7,0});
		System.out.println(num);

	}
	
	public int InversePairs(int[] array){
		if(array == null||array.length == 0)return 0;
		int[] tmp = new int[array.length];
		int count = InversePairs(array,tmp,0,array.length-1);
		return count;
	}
	
	private int InversePairs(int[] array, int[] tmp, int left, int right){
		if(left == right)return 0;
		int mid = (left+right)>>1;
		int leftCount = InversePairs(array, tmp, left, mid);
		int rightCount = InversePairs(array, tmp, mid+1, right);
		int count = merge(array,tmp,left,mid+1,right);
		int all = count + rightCount + leftCount;
		if(all >= 1000000007)return all%1000000007;
		return all;
	}
	
	private int merge(int[] array,int[] tmp, int leftPos,int rightPos,int rightEnd){
		int leftEnd = rightPos - 1;
		int num = rightEnd - leftPos + 1;
		int mid = leftEnd;
		int tmpPos = leftPos;
		int count = 0;
		while(leftPos <= leftEnd && rightPos <= rightEnd){
			if(array[leftPos] < array[rightPos]){
				tmp[tmpPos++] = array[leftPos++];
			}else{
				tmp[tmpPos++] = array[rightPos++];
				count += mid - leftPos + 1;
				if(count >= 1000000007 )count = count%1000000007;
			}
		}
		while(leftPos<=leftEnd){
			tmp[tmpPos++] = array[leftPos++];
		}
		while(rightPos<=rightEnd){
			tmp[tmpPos++] = array[rightPos++];
		}
		for(int i=0;i<num;i++,rightEnd--){
			array[rightEnd] = tmp[rightEnd];
		}
		return count;
	}
}
