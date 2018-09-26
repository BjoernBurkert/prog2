package aufgabe8;

public class Laufzeitmessung {
	
	final static int n = 100;
	public static void main(final String[] args){
		long time = System.currentTimeMillis();
		int[] array = new int[n];
		generaterandom(array);
		DualPivotQuickSort.dualPivotSort(array, 0, n-1);
		Laufzeitmessung.isSorted(array);
		Laufzeitmessung.ausgeben(array);
		System.out.println(isSorted(array));
		System.out.printf("Zeit zum Sortieren: %d Millisekunden", System.currentTimeMillis() - time);
		
		
	}
	public static void generaterandom(int[] a){
		for (int i = 0; i < n; i++){
			a[i] = (int) (Math.random() * n);
		}
	}
	public static void ausgeben(int [] y){
		for(int a : y){
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	public static boolean isSorted(int[] a){
    	for (int i = 0; i < a.length-1; i++)
    		if (a[i+1] < a[i])
    			return false;
    	return true;
    }
	

}
