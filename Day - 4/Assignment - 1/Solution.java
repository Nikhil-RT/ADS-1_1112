class Solution{
	Solution() {
	}
	public static int[] quickSort(int[] arr){
		// fill you code Here
		sort(arr, 0, arr.length - 1);
		return arr;
	}
	public static void sort(int[] arr, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int j = partition(arr, lo, hi);
		sort(arr, lo, j - 1);
		sort(arr, j + 1, hi);
	}
	// function to divide the function based on the pivot position.

	public static int partition(int[] arr, int lo, int hi) {
		int i = lo;
		int j = hi + 1;

		while (true) {
			while (arr[++i] < arr[lo]) {
				if (i == hi) {
					break;
				}
			}
			while (arr[lo] < arr[--j]) {
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		int temp = arr[lo];
		arr[lo] = arr[j];
		arr[j] = temp;
		return j;
	}
}