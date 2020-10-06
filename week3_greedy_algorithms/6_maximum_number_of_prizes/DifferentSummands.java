import java.util.*;

public class DifferentSummands {
    private static List<Long> optimalSummands(long n) {
        List<Long> summands = new ArrayList<Long>();
        //write your code here
        long num = getChildNum(n);
        for(long i=1; i<=num; i++) {
            summands.add(i);
            n -= i;
        }
        if(summands.size() == 0) {
            summands.add(n);
            return summands;
        }
        if(n>0) {
            summands.set((int) num-1, summands.get((int) num-1) + n);
        }
        return summands;
    }

    private static long getChildNum(long n) {
        int sum = 0;
        for(long i=1; i<n; i++) {
            if((sum <= n) && (n < sum + i)) {
                return i-1;
            } else {
                sum += i;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Long> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Long summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

