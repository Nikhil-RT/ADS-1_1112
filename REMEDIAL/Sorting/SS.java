import java.util.*;

public class SS {

	//Selection Sort -
	public static void sort(int []a, int i, int j) {
		// int i;
		// int j;
		int N = a.length;

		for (i = 0; i < N; i++) {
			int min = i;

			for (j = i + 1; j < N; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}


}