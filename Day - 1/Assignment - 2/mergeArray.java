import java.util.*;

class mergeArray{
    public static void main(String[] args) {
        int[] a1 = {5,9,15,18,59};
        int[] a2 = {1,11,19,50,89,100};
        int n1 = a1.length;
        int n2 = a2.length;
        int[] merge = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;
        int x;
        
       while (i < n1 && j < n2) {
            if (a1[i] < a2[j]) {
            merge[k++] = a1[i++];
            }else {
            merge[k++] = a2[j++];
            }
        }
    while (i < n1){
        merge[k++] = a1[i++];
    }while (j < n2){
        merge[k++] = a2[j++];
    }for (x = 0; x < n1 + n2; x++){
        System.out.println(merge[x]);
    }
    }    
}