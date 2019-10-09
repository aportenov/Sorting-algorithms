package sorting.selection;

import java.util.Comparator;

public class SelectionSort {
    
    private SelectionSort() {}
    
    public static<T extends Comparable<T>> void sort(T[] array) {
	int arrSize = array.length;
	for (int i = 0; i < arrSize; i++) {
	    int min = i;
	    for (int j = i+1; j < arrSize; j++) {
		if(isLess(array[j], array[min]))
		    min = j;
	    }
	    
	    exchange(array, i, min);
	}
    }
    
    public static<T> void sort(T[] array, Comparator<T> comparator) {
	int arrSize = array.length;
	for (int i = 0; i < arrSize; i++) {
	    int min = i;
	    for (int j = i+1; j < arrSize; j++) {
		if(isLess(array[j], array[min], comparator))
		    min = j;
	    }
	    
	    exchange(array, i, min);
	}
    }

    private static<T> void exchange(T[] array, int currentMin, int newMin) {
	T swap = array[currentMin];
	array[currentMin] = array[newMin];
	array[newMin] = swap;
    }

    private static<T> boolean isLess(T current, T min, Comparator<T> comparator) {
	return comparator.compare(current, min) < 0;
    }

    private static<T extends Comparable<T>> boolean isLess(T current, T min) {
	return current.compareTo(min) < 0;
    }
    
   
}
