import java.util.Arrays;

class mergeArray{
    public int[] sum(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int asize = 0;
        int bsize = 0;
        int csize = 0;

        while(csize != c.length) {
            
            if(asize == a.length) {
                c[csize++] = b[bsize++];}
                else if(bsize == b.length){
                  c[csize++] = a[asize++];
                }
                else if (a[asize] < b[bsize]) {
                    c[csize++] = a[asize++];
                }
                else {
                    c[csize++] = b[bsize++];
                }
        }return c;
    }

}

public class MergeSort{
    public static void main(String[] args) {
        // mergeArray obj = new mergeArray();
        mergeArray obj = new mergeArray();
        int[] a1 = {5,9,15,18,59};
        int[] a2 = {1,11,19,50,89,100};
        int[] merging = obj.sum(a1, a2);
        System.out.println(Arrays.toString(merging));
    }   
}      