import java.util.*;

class InsertionSentinal {

    public int[] Insertionsort(int[] a) {
        
        int i,j,temp;

        for (i = 1; i < a.length; i++) {
            j = i - 1;
            temp = a[i];

            while (j > 0 && temp < a[j]) {
                a[j+1] = a[j];
                j = j-1;
            }
            a[j+1] = temp;
        }
        return a;
    }


    public static int[] SentinalIns(int[] a) {

        int i, j, temp, min, minIndex;

        minIndex = 0;
        min = a[0];

        int n = a.length;
        for (i = 1; i < n; i++) {

            if (min > a[i]) {
                min = a[i];
                minIndex = i;
            }
        }
        a[minIndex] = a[0];
        a[0] = min;

        for (i = 2; i < n; i++) {
            temp = a[i];
            j = i - 1;

            while (j >= min && a[j] > temp) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = temp;
        }
        return a;
    }

    public static void main(String[] args) {

        int[] a = new int[] {10,-5,6,-3,11,-2,3,0};

        System.out.println(Arrays.toString(SentinalIns(a)));
    }
}