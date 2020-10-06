import java.util.*;

public class Knapsack {
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
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

