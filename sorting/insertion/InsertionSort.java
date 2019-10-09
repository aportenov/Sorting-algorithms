package sorting.insertion;

import java.util.Comparator;

public class InsertionSort {
    
    private InsertionSort() {}
    
    public static<T extends Comparable<T>> void sort(T[] array) {
	int arrSize = array.length;
	for (int i = 1; i < arrSize; i++) {
	    for(int j = i; j > 0 && isLess(array[j], array[j-1]); j--) {
		exchange(array, j, j-1);
	    }
	}
		
    }
    
    
    public static<T> void sort(T[] array , Comparator<T> comparator) {
	int arrSize = array.length;
	for (int i = 0; i < arrSize; i++) {
	    for (int j = i; j > 0 && isLess(array[j], array[j-1], comparator); j--) {
		exchange(array, j, j-1);
	    }
	}
    }
    
    private static<T> void exchange(T[] array, int current, int prev) {
	T swap = array[current];
	array[current] = array[prev];
	array[prev] = swap;
    }

    private static<T> boolean isLess(T current, T prev, Comparator<T> comparator) {
	return comparator.compare(current, prev) < 0;
    }

    private static<T extends Comparable<T>> boolean isLess(T current, T prev) {
	return current.compareTo(prev) < 0;
    }

}


