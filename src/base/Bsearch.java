package base;

public class Bsearch {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2,3,4,7,12,15,17,23,26};
        int bsearch = bsearch(a, a.length, 12);
        System.out.println(bsearch);
    }

    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (value > a[mid] ) {
                low = mid - 1;
            } else if (value < a[mid]) {
                high = mid + 1;
            } else {
                return mid ;
            }
        }
        return -1;
    }
}
