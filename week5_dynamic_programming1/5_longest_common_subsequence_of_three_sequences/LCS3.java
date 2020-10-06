import java.util.*;

public class LCS3 {

    private static int lcs3(long[] a, long[] b, long[] c) {
        int n = a.length;
        int m = b.length;
        int k = c.length;
        int[][][] D = new int[n+1][m+1][k+1];
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= m ; j++) {
                D[i][j][0] = 0;
            }
        }
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= k ; j++) {
                D[i][0][j] = 0;
            }
        }
        for (int i = 0; i <= m ; i++) {
            for (int j = 0; j <= k ; j++) {
                D[0][i][j] = 0;
            }
        }
        for (int l = 1; l <= k; l++) {
            for (int j = 1; j <= m; j++) {
                for (int i = 1; i <= n; i++) {
                    int x = D[i-1][j-1][l-1];
                    int y = D[i-1][j][l];
                    int z = D[i-1][j-1][l];
                    int t = D[i-1][j][l-1];
                    int p = D[i][j-1][l];
                    int r = D[i][j][l-1];
                    int s = D[i][j-1][l-1];
                    if ((a[i - 1] == b[j - 1]) && (b[j - 1] == c[l - 1])) {
                        D[i][j][l] = Math.max(Math.max(Math.max(Math.max(r, s), Math.max(t, p)), Math.max(y, z)), x + 1);
                    } else {
                        D[i][j][l] = Math.max(Math.max(Math.max(Math.max(r, s), Math.max(t, p)), Math.max(y, z)), x);
                    }
                }
            }
        }
        return D[n][m][k];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        long[] a = new long[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        long[] b = new long[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        long[] c = new long[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

