class Solution{
	Solution() {
	}
	public static int[] quickSort(int[] arr){
		// fill you code Here
		sort(arr, 0, arr.length - 1);
		return arr;
	}
	public static void sort(int[] arr, int lo, int hi) {
		if (high <= low) {
			return;
		}
		int j = partition(arr, lo, hi);
		sort(arr, low, j - 1);
		sort(arr, j + 1, high);
	}
	// function to divide the function based on the pivot position.

	public static int partition(int[] arr, int low, int high) {
		int i = low;
		int j = high + 1;

		while (true) {
			while (arr[++i] < arr[low]) {
				if (i == high) {
					break;
				}
			}
			while (arr[low] < arr[--j]) {
				if (j == low) {
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