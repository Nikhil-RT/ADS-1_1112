import java.util.Arrays;

public class threeSum {
    public static void main(String[] args) {
        int [] a = {20,-1,-19,-16,4,12};
        int N = a.length;
        Arrays.sort(a);
        int count = 0;
        int high  = a.length-1;
        int low = 0;
        int medium;

        for (int i = 0; i < N; i++) {

            for (int j = i + 1; j < N; j ++) {

                high = a.length - 1;
                low = 0;
                
                while(low <= high){
                    medium = (high + low)/2;

                    if( -a[medium] == a[i]+a[j] ) {

                        if(a[low] < a[medium] && a[medium] < a[high]) 
                            count++;
                            break;

                    }else if (a[medium] < (a[i]+a[j])*-1) {
                        low = medium + 1;
                    }
                    else {
                       high = medium - 1;
                    }
                }
            }
        }
         System.out.println(count);    
    }   
}