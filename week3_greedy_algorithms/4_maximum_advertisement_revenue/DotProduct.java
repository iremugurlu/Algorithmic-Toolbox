import java.util.*;

public class DotProduct {

//    private static long maxDotProduct(int[] a, int[] b) {
//        int n = a.length;
//        int[][] arr = new int[n+1][n+1];
//        arr[0][0] = 0;
//        for (int i = 1; i <= n ; i++) {
//            for (int j = 1; j <= n ; j++) {
//                arr[i][j] = Integer.max(arr[i-1][j-1] + a[j-1]*b[i-1], arr[i][j-1]);
//            }
//        }
//        return arr[n][n];
//    }

    private static long maxDotProduct(long[] a, long[] b) {
        long result = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

