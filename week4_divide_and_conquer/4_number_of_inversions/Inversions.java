import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        return numberOfInversions;
    }

    private static int[] mergeSort(int[] a) {
        int n = a.length;
        if(n==1) {
            return a;
        }
        int m = n/2;
        int[] B = new int[m];
        int[] C = new int[n-m];
        for (int i = 0; i < m; i++) {
            B[i] = a[i];
        }
        for (int i = 0; i < n-m; i++) {
            C[i] = a[i+m];
        }
        int[] result = merge(B, C);
        return result;
    }

    private static int[] merge(int[] B, int[] C) {
//        List<> Bl = new ArrayList<Integer>(Arrays.asList(B));
//        List<> Cl = Arrays.asList(C);
//        List
//        int[] D = new int[p+q];
//        while(p>0 && q>0) {
//            int b = B[0];
//            int c = C[0];
//            if(b <= c) {
//
//            }
//        }
        return new int[3];
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

