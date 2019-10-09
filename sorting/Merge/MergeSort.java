package sorting.Merge;

import java.util.stream.IntStream;

public class MergeSort {

    private MergeSort() {}
    
    @SuppressWarnings("unchecked")
    public static<T extends Comparable<T>> void sort(T[] array){
	T[] tempArr = (T[]) new Comparable[array.length];
	sort(array, tempArr, 0 , array.length-1);
    }

    private static<T extends Comparable<T>> void sort(T[] leftSide, T[] rightSide, int start, int end) {
	if(end <= start) return;
	int mid = start + (end - start)/2;
	sort(leftSide, rightSide, start, mid);
	sort(leftSide, rightSide, mid+1, end);
	merge(leftSide, rightSide, start, mid, end);
	
    }

    private static<T extends Comparable<T>> void merge(T[] leftSide, T[] rightSide, int start, int mid, int end) {
	 IntStream.rangeClosed(start, end).forEach(index -> rightSide[index] = leftSide[index]);
	
	int i = start, j = mid+1;
	for(int k = start; k <= end; k++) {
	    if(i > mid) 
		leftSide[k] = rightSide[j++];
	    else if(j > end) 
		leftSide[k] = rightSide[i++];
	    else if(isLess(rightSide[j], rightSide[i])) 
		leftSide[k] = rightSide[j++];
	    else 
		leftSide[k] = rightSide[i++];
	}
	
	
    }

    private static<T extends Comparable<T>> boolean isLess(T current, T next) {
	return current.compareTo(next) < 0;
    }

}
