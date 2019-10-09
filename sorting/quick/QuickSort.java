package sorting.quick;

public class QuickSort {
    
    private QuickSort() {}
    
    public static<T extends Comparable<T>> void sort(T[] array) {
	sort(array, 0, array.length-1);
    }

    private static<T extends Comparable<T>> void sort(T[] array, int start, int end) {
	if(end <= start) return;
	int j = partition(array, start, end);
	sort(array, start, j-1);
	sort(array, j+1, end);
    }

    private static<T extends Comparable<T>> int partition(T[] array, int start, int end) {
	int i = start;
	int j = end+1;
	T temp = array[start];
	while(true) {
	    
	    while(isLess(array[++i], temp)) 
		if(i == end) break;
	  
	    while(isLess(temp, array[--j])) 
		if(j == start) break;
	    
	    if(i >= j)
		break;
	    
	    exchange(array, i, j);
	}
	
	exchange(array, start, j);
	
	return j;
    }

    private static<T extends Comparable<T>> void exchange(T[] array, int start, int end) {
	T swap = array[start];
	array[start] = array[end];
	array[end] = swap;
	
    }

    private static<T extends Comparable<T>> boolean isLess(T t, T v) {
	if(t == v) return false;
	return t.compareTo(v) < 0;
    }
    
    public static void main(String[] args) {
   	Integer[] arr = new Integer[] {1,6,7,3,2,4,5};
   	QuickSort.sort(arr);
   	for (Integer i : arr) {
   	    System.out.print(i + " ");
   	}
   	
       }

}
