package aufgabe8;

public class QuickSort3Median {
	  static int[] intArray = { 5, 4, 13, 11, 3, 10, 2, 8, 6, 9, 12 };
		public static void main(String[] args) {
			long time = System.currentTimeMillis();
			quickSort(intArray, 0, intArray.length - 1);
			System.out.printf("Zeit zum Sortieren: %d millisekunden", System.currentTimeMillis() - time);
		}
		
		
		public static void swap(int[] intArray, int dex1, int dex2) {
			int temp = intArray[dex1];
			intArray[dex1] = intArray[dex2];
			intArray[dex2] = temp;
		}
		
		public static void quickSort(int[] a, int li, int re){
			//Sortiert Teilfeld a[li], a[li+1], ... , a[re].
			
			if(re > li){
				//Teilschritt:
				int i = partition(a, li, re);
				
				//Herrscheschritt:
				//if(i-li < re-i){
				quickSort(a, li, i-1);
				quickSort(a, i+1, re);
				//}
				//else {
				//	quickSort(a, i+1, re); 
				//	quickSort(a, li, i-1); 
				//}
			}
		}

		public static int partition(int a[] , int li, int re) {
			
			int median;
	        if (a[li] <= a[(re + li) / 2] && a[(re + li) / 2] <= a[re]) {
	            // mittlere zahl ist median
	            median = a[(re + li) / 2];
	            a[(re + li) / 2] = a[re];
	            a[re] = median;
	        } else if (a[(re + li) / 2] <= a[li] && a[li] <= a[re]) {
	            // li ist median
	            median = a[li];
	            a[li] = a[re];
	            a[re] = median;
	        }
			for(int x : intArray){
				System.out.printf("%d ",x);
			}
			System.out.println("");
		
			
			int v = a[re];
			int i = li-1;
			int j = re;

			while (true) {
				do i++;while(a[i]<v);
				do j--;while(j>=li && a[j]>v);
				if(i>=j)
					break;
				//a[i] und a[j vertauschen:
				int t = a[i]; a[i]=a[j]; a[j]=t;
		}
			for(int x : intArray){
				System.out.printf("%d ",x);
			}
			System.out.println("");
		
		// Pivotelement a[r] und a[i] vertauschen:
			a[re]=a[i]; a[i]=v;
			return i;
		}
		
		
			
		public static void ausgeben(int [] y){
//			for(int a : y){
//				System.out.print(a + " ");
//			}
//			System.out.println();
//		}
		}

	}
