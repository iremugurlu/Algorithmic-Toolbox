import java.util.*;

public class Partition3 {
    private static int partition3(int[] A) {
        int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }
        if(sum%3 != 0) {
            return 0;
        }
        if(optimalWeight(sum/3, A) == sum/3) {
            return 1;
        }
        return 0;
    }

    static int optimalWeight(int W, int[] w) {
        int n = w.length;
        int[][] value = new int[W+1][n+1];
        for (int i = 0; i <= n; i++) {
            value[0][i] = 0;
        }
        for (int i = 0; i <= W ; i++) {
            value[W][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W ; j++) {
                value[j][i] = value[j][i-1];
                if(w[i-1] <= j) {
                    int val = value[j - w[i-1]][i-1] + w[i-1];
                    if(value[j][i] < val) {
                        value[j][i] = val;
                    }
                }
            }
        }
        return value[W][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

