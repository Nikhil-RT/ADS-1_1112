class Solution {
	
	public static boolean isMinHeap(double[] arr) {
		if(arr.length == 0){
			return false;
		}
		
		for ( int i = 0; i <= arr.length; i++) {
			// System.out.println(arr[i]);
			// if( arr[0] <= arr.length-1 || arr[0] <= 0) {
				if(2*i+1 < arr.length && 2*i+2 < arr.length) {

					if( arr[i] > arr[2*i+1]  && arr[i] > arr[2*i+2] ) {
						return false;
					}	
			}
		}
		return true;
	}
	public static void main(String[] args) {
		double[] arr = {121,125,123,126,127,124};
		System.out.println(isMinHeap(arr));
	}
}