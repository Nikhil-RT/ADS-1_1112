class Solution {
	Solution() {
	}
	
	// function to call the sort function.

	public static String[] mergeSort(String[] arr){
		// fill you code Here
		String[] aux = new String[arr.length];
		sort(arr, aux, 0, arr.length - 1);
		return arr;
	}

	// the function to sort the array in ascending order.

	public static void sort(String[] arr, String[] aux, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int mid = (lo + hi) / 2;
		sort(arr, aux, lo, mid);
		sort(arr, aux, mid + 1, hi);
		merge(arr, aux, lo, mid, hi);
	}

	// the function to merge the parts in ascending order.

	public static void merge(String[] arr, String[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = arr[k];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				arr[k] = aux[j++];
			} else if (j > hi) {
				arr[k] = aux[i++];
			} else if (aux[j].compareTo(aux[i]) < 0) {
				arr[k] = aux[j++];
			} else {
				arr[k] = aux[i++];
			}
		}
	}
	
}