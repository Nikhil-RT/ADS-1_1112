import java.util.*;

public class SS {

	//Selection Sort -
	public static void sort(int []a) {

		int N = a.length;

		for (int i = 0; i < N; i++) {
			int min = i;

			for (int j = i + 1; j < N; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int swap = a[i];
			a[i] = a[j];
			a[j] = swap;
		}
	}
}