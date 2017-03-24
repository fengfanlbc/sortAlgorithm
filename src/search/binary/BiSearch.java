package search.binary;

public class BiSearch {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,5,6,7,10};
		int s = 4;
		System.out.println(search(a, 5));
		System.out.println(searchLast(a, 5));

	}

	/**
	 * 二分法查找某一个元素
	 * @param a
	 * @param s
	 * @return
	 */
	public static int search(int a[],int s){
		if(a.length==0||a==null){
			return -1;
		}
		int first = 0;
		int last = a.length-1;
		int mid = 0;
		//必须包含等于号因为last或者first有可能指向查找元素
		while(last>=first){
			mid = (first+last)/2;
			if(a[mid] == s){
				return mid;
			}
			if(a[mid] > s){
				last = mid-1;
			}else{
				first = mid+1;
			}
		}
		return -1;
	}
	
	/**
	 * 用二分法查找一个元素最后出现的位置
	 * 这里要注意，mid = (first+last+1)/2;
	 * 因为二分法查找到最后，first和last相邻，在结束前会有两种
	 * 情况：1.first指向了查找元素，last也指向了查找元素
	 * 那么最后一次二分，first和last相等都应该指向最后一个
	 * 2.first指向查找元素，last没有指向，那么最后一次二分
	 * last应该减一指向最后一个查找元素
	 * 3.都没有指向
	 * 4.last指向了first没指向
	 * @param a
	 * @param s
	 * @return
	 */
	public static int searchLast(int a[],int s){
		if(a.length==0||a==null){
			return -1;
		}
		int first = 0;
		int last = a.length-1;
		int mid = 0;
		while(last > first){
			mid = (first+last+1)/2;
			if(a[mid] <= s){
				first = mid;
			}else{
				last = mid-1;
			}
		}
		if(a[first]==s)
			return a[first];
		else
			return -1;
	}
}
