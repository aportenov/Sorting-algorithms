package sorting.shell;

public class ShellSort {
    
    private ShellSort() {}
    
    public static<T extends Comparable<T>> void sort(T[] array) {
	int arrSize = array.length;
	int hash = 1;
	while(hash < arrSize/3) { 
	    hash = 3*hash + 1;
	}
	
	while(hash >= 1) {
	    for(int i = hash; i < arrSize; i++) {
		for(int j = i; j >= hash && isLess(array[j], array[j-hash]); j -= hash) {
		    exchange(array, j, j-hash);
		}
	    }
	    
	    hash /= 3;
	}
    }

    private static<T extends Comparable<T>> void exchange(T[] array, int current, int hashed) {
	T swap = array[current];
	array[current] = array[hashed];
	array[hashed] = swap;
    }

    private static<T extends Comparable<T>> boolean isLess(T current, T hashed) {
	return current.compareTo(hashed) < 0;
    }
}
