final class Solution {
    private Solution() { }
    public static boolean isMinHeap(final double[] arr) {
        int a = arr.length;
        if (a == 0) {
            return false;
        }
        for (int i = 0; i <= a; i++) {
                if (2 * i + 1 < a && 2 * i + 2 < a) {
                    if (arr[i] > arr[2 * i + 1]
                    || arr[i] > arr[2 * i + 2]) {
                        return false;
                    }
            }
        }
        return true;
    }
}
