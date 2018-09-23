public class QuickSort1 {

    public static void sort(int[] a, int from, int to) {
        if (from >= to) {
            return;
        }
        int p = partition(a, from, to);
        sort(a, from, p);
        sort(a, p + 1, to);
    }

//hej
    public static int partition(int[] a, int from, int to) {

        int i = a[from];
        int j = a[to + 1];
        int pivot = a[from];
        while (a[i++] < a[j--]) {
            if (i == to) break;
        while (a[i++] > a[j++]) {
            if (j == from) break;
        }
        if (i > j) break;

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;


        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return j;

    }
}
