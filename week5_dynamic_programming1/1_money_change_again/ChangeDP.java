import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] minNum = new int[m+1];
        for (int i = 1; i <= m; i++) {
            minNum[i] = Integer.MAX_VALUE;
            int[] coins = {1, 3, 4};
            for (int j = 0; j < 3; j++) {
                if(i>=coins[j]) {
                    int numCoins = minNum[i-coins[j]] + 1;
                    if(numCoins<minNum[i]) {
                        minNum[i] = numCoins;
                    }
                }
            }
        }
        return minNum[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

