import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        int n = (exp.length()+1)/2;
        long[][] m = new long[n+1][n+1];
        long[][] M = new long[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            m[i][i] = exp.charAt((i-1)*2) - '0';
            M[i][i] = exp.charAt((i-1)*2) - '0';
        }
        for (int s = 1; s <= n-1; s++) {
            for (int i = 1; i <= n-s; i++) {
                int j = i + s;
                m[i][j] = MinAndMax(i, j, M, m, exp)[0];
                M[i][j] = MinAndMax(i, j, M , m , exp)[1];
            }
        }
        return M[1][n];
    }

    private static long[] MinAndMax(int i, int j, long[][] M, long[][] m, String exp) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int k = i; k < j; k++) {
            long a = eval(M[i][k], M[k+1][j], exp.charAt(2*k-1));
            long b = eval(M[i][k], m[k+1][j], exp.charAt(2*k-1));
            long c = eval(m[i][k], M[k+1][j], exp.charAt(2*k-1));
            long d = eval(m[i][k], m[k+1][j], exp.charAt(2*k-1));
            min = Long.min(min, Long.min(Long.min(a, b), Long.min(c, d)));
            max = Long.max(max, Long.max(Long.max(a, b), Long.max(c, d)));
        }
        long[] res = new long[2];
        res[0] = min;
        res[1] = max;
        return res;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

