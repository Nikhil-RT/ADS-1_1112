import java.util.Collections;
import java.util.PriorityQueue;
class Solution{
	public static double[] dynamicMedian(double[] arr){

		PriorityQueue<Double> MinPQ = new PriorityQueue<Double>();

		PriorityQueue<Double> MaxPQ = new PriorityQueue<Double>(Collections.reverseOrder());
		
		double[] res = new double[arr.length];
		double median = arr[0];

		MinPQ.add(median);
		res[0] = median;

		for(int i = 1; i < arr.length; i++) {

			if (MinPQ.size() > MaxPQ.size()) {
                if (arr[i] > median) {
                    MaxPQ.add(MinPQ.remove());
                    MinPQ.add(arr[i]);
                } else {
                    MaxPQ.add(arr[i]);
                }
				median = (MinPQ.peek() + MaxPQ.peek()) / 2.0;
				
            } else if (MinPQ.size() < MaxPQ.size()) {
                if (arr[i] < median) {
                    MinPQ.add(MaxPQ.remove());
                    MaxPQ.add(arr[i]);
                } else {
                    MinPQ.add(arr[i]);
                }
				median = (MinPQ.peek() + MaxPQ.peek()) / 2.0;
				
            } else {
                if (arr[i] < median) {
                    MaxPQ.add(arr[i]);
                    median = MaxPQ.peek();
                } else {
                    MinPQ.add(arr[i]);
                    median = MinPQ.peek();
                }
			}
			
            res[i] = median;
        }
        return res;
    }
}