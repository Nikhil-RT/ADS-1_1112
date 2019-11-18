import java.util.Arrays;
import java.util.Collections;
/**
 * Building a minimum - oriented PQ , after doing the Min PQ 
 * operations on the given array, like sink and swim.
 * It removes the k smallest elements and returns
 * @author Nikhil ravi teja
 */

class MinPQ {

    public int[] pq;   // Integer array
    public int n;      // size
    
    //Constructor MinPQ
    public MinPQ(int initialCapacity) {
        pq = new int [initialCapacity + 1];
        n = 0;
    }

    //Returns the number of ints on PQ.
    public int size() {
        return n;
    }

    //Adds a new int to the PQ.
    public void insert(int x) {
        // double size of array if necessary
        //if (n == pq.length - 1) resize(2 * pq.length);
        pq[++n] = x;
        swim(n);
    }

    // Removes and returns a smallest int on this PQ.
    public int delMin() {
        int min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = 0;
        return min;
    }

    //SwimOp after insert
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    //SinkOp after delete
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    //Retuns boolean
    private boolean greater(int i, int j) {
        if(pq[i] > pq[j]) {
            return true;
        }
        else {
            return false;
        }
    }
    //Exchange function
    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
/**
 * Removing the Minimum elements and returning them
 */
class MinOp {
    public static void main(String[] args) {

        int a[] = {8,4,5,2,1,3,7,19,6};  //integer array
        int k = 3;  //No. of elements to be returned

        //creating mq object with class MinPQ of size 10
        MinPQ mq = new MinPQ(15);

        //Iterating loop for insert
        for(int i = 0; i < a.length; i++) {
            mq.insert(a[i]);
        }
        System.out.println("After Inserting (mq): " + Arrays.toString(mq.pq));
        System.out.println("The size of mq is : "+mq.size());

        System.out.println("==========================================================================");
        System.out.println("The Output : ");
        //Iterating loops for delete
        for (int j = 0; j < k; j++) {
            System.out.println(mq.delMin());
        }
        System.out.println("==========================================================================");
        System.out.println("After Deletion (min) "+k+" elements : "+ Arrays.toString(mq.pq));
    }
}
