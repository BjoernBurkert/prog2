package quicksortBeispiel;

public class quicksort {
	
	public static int[] intArr = {16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3, 19};
	
	public int[] sort(int li, int re){
		int q;
		if (li < re){
			q = partition(li, re);
			sort(li, q);
			sort(q + 1, re);
		}
		return intArr;
	}
	
	int partition(int li, int re){
		int i, j, x = intArr[(li + re)/2];
		i = li - 1;
		j = re + 1;
		
		do {
			i++;
		} while (intArr[i] < x );
		
		do {
			j--;
		} while (intArr[j] > x);
		
		if (i < j){
			int k = intArr[i];
			intArr[i] = intArr[j];
			intArr[j] = k;
		} else {
			return j;
		}
		return -1;
	}
	
	public static void main(String[] args){
		quicksort qs = new quicksort();
		int[] arr = qs.sort(0, intArr.length - 1);
		for (int i = 0; i < arr.length; i++ ){
			System.out.println(i + 1 + ": " + arr[i]);
		}
	}

}
 