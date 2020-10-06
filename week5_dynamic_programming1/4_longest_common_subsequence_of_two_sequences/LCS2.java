import java.util.*;

public class LCS2 {

    private static int lcs2(long[] a, long[] b) {
        int n = a.length;
        int m = b.length;
        int[][] D = new int[n+1][m+1];
        for (int i = 0; i <= n ; i++) {
            D[i][0] = 0;
        }
        for (int j = 0; j <= m ; j++) {
            D[0][j] = 0;
        }
        for (int j = 1; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                int insertion = D[i][j-1];
                int deletion = D[i-1][j];
                int match = D[i-1][j-1] + 1;
                int mismatch = D[i-1][j-1];
                if(a[i-1] == b[j-1]) {
                    D[i][j] = Integer.max(Integer.max(insertion, deletion), match);
                } else {
                    D[i][j] = Integer.max(Integer.max(insertion, deletion), mismatch);
                }
            }
        }
        return D[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        long[] b = new long[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

