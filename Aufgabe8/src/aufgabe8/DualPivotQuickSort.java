package aufgabe8;

public class DualPivotQuickSort {
		  
	public static void dualPivotSort(int[] intArray) {
        dualPivotSort(intArray, 0, intArray.length -1);
    }
       
   
    public static void dualPivotSort(int[] intArray, int li, int re) {
        if (re <= li) {
            return;
        }
       
        int indexv1 = 0;
        int indexv2 = 0;
        int v1 = 0;
        int v2 = 0;
       
        if (re - li > 4) {     
           
            int a = (re - li) / 5;
            int[] subArray = {intArray[li+a-1], intArray[li+a*2-1], intArray[li+a*3-1], intArray[li+a*4-1], intArray[li+a*5-1]};
            int max = subArray[0];
            int min = subArray[0];
            int zweitkleinste = Integer.MAX_VALUE;
            int zweitgroesste = 0;
            indexv2 = 0;
            indexv1 = 0;
            int indexmax = 0;
            int indexmin = 0;
 
           
            for (int i = 1; i < subArray.length; i++) {
                if (subArray[i] >= max) {
                    zweitgroesste = max;
                    indexv2 = indexmax;
                    max = subArray[i];
                    indexmax = i;
                }
                if(max > subArray[i] && zweitgroesste < subArray[i]) {
                    zweitgroesste = subArray[i];
                    indexv2 = i;
                }
                                           
                if (subArray[i] <= min) {
                    zweitkleinste = min;
                    indexv1 = indexmin;
                    min = subArray[i];
                    indexmin = i;
                }
                if(min < subArray[i] && zweitkleinste > subArray[i]) {
                    zweitkleinste = subArray[i];
                    indexv1 = i;
                }
            }
           
            indexv1 = li + getIndex(indexv1, a);
            indexv2 = li + getIndex(indexv2, a);
            v1 = intArray[indexv1];
            v2 = intArray[indexv2];
       
            int tauschvariable = intArray[indexv1];
            int tauschvariable2 = intArray[indexv2];
            int tauschvariable3 = intArray[li];
            int tauschvariable4 = intArray[re];
            intArray[indexv1] = tauschvariable3;
            intArray[indexv2] = tauschvariable4;
            intArray[li] = tauschvariable;
            intArray[re] = tauschvariable2;
 
        } else  {
            if (intArray[li] > intArray[re]) {
                indexv2 = li;
                indexv1 = re;
                v1 = intArray[indexv1];
                v2 = intArray[indexv2];
                swap(intArray,li,re);
            } else {
                indexv1 = li;
                indexv2 = re;
                v1 = intArray[indexv1];
                v2 = intArray[indexv2];
            }
        }
               
        int l = li+1;
        int k = li+1;
        int g = re-1;
       
        while (k <= g) {
            if (intArray[k] < v1) {
                swap(intArray, k, l);
                ++l;
            } else if (intArray[k] >= v2) {
                while (intArray[g] > v2 && k < g) {
                    g--;
                }
                swap(intArray, k, g);
                g--;
                if (intArray[k] < v1) {
                    swap(intArray, k, l);
                    l++;
                }
            }
            k++;       
        }
        l--;
        g++;
       
        swap(intArray, li, l);
        swap(intArray, re, g);
 
        dualPivotSort(intArray, li, l-1);
        dualPivotSort(intArray, l + 1, g - 1);
        dualPivotSort(intArray, g + 1, re);
    }
   
    private static void swap (int[] intArray, int id1, int id2) {
        int tauschvariable = intArray[id1];
        intArray[id1] = intArray[id2];
        intArray[id2] = tauschvariable;
    }
   
    private static int getIndex(int index, int a) {
        switch (index) {
        case 0 : return a-1;
        case 1 : return a*2-1;
        case 2 : return a*3-1;
        case 3 : return a*4-1;
        case 4 : return a*5-1;
        }
        return -1;
    }
}
