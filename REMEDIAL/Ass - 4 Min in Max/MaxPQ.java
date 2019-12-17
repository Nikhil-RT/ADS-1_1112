import java.util.*;

public class MaxPQ {
    static int[] pq;
    int n = 1;  
    int min;
    int key;

    public MaxPQ(){
        MaxPQ.pq = new int[10];
        min = Integer.MAX_VALUE;
    }

    public boolean isempty() {
        return n == 0;
    }

    public void exchange(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public void swim(int k) {
        while(k > 1 && (k/2 > k)) {
            exchange(k,k/2);
            k = k/2;
        }
    }

    public void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j > 1 && (j < j+1) ){
                j++;
            }
            if (!(k < j)) break;
            exchange(k,j);
            k = j;
        }
    }

    public void insert(int key) {
        if (min > key) min = key;
        pq[n] = key;
        n++;
        swim(n);
    }

    public int min() {
        if (isempty()) throw new NoSuchElementException("It is Empty");
        return min;
    }

    public int max() {
        if (isempty()) throw new NoSuchElementException("It is Empty");
        return pq[1]; 
    }

    public int deletemax() {
        if (isempty()) throw new NoSuchElementException("It is Empty");
        int max = pq[1];
        exchange(1,n--);
        sink(1);
        pq[n+1] = 0;    //To avoid loitering, if we don't keep this condition
        //it will still show the max value at n+1st postion
        return max;
    }

    public static void main(String[] args) {
        MaxPQ obj = new MaxPQ();
        obj.insert(15);
        obj.insert(13);
        obj.insert(11);
        obj.insert(9);
        obj.insert(7);
        obj.insert(3);
        obj.insert(5);
        System.out.println("==================================");
        System.out.println("PQ - Array : " + Arrays.toString(pq));
        System.out.println("==================================");
        System.out.println("Minimum Element : " + obj.min());
        System.out.println("==================================");
        System.out.println("Maximum Element : " + obj.max());
        System.out.println("==================================");
        System.out.println("Delete Maximum Element : " + obj.deletemax());
        System.out.println("==================================");
        System.out.println("Modified PQ - Array : " + Arrays.toString(pq));
        System.out.println("==================================");
        System.out.println("Minimum Element : " + obj.min());
    }

}