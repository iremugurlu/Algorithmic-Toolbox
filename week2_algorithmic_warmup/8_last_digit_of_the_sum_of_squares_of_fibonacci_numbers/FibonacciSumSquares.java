import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {

        n = n%getPisonaPeriod(10);

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        if (n <= 1)
            return n;

        for (long i = 0; i < n-1 ; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
            sum = (sum + current * current) % 10 ;
        }

        return sum % 10;
    }

    private static long getPisonaPeriod(long m) {
        long previous = 0;
        long current  = 1;
        for (int i = 0; i < m*m; i++) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;

            if(previous == 0 && current == 1) {
                return i+1;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}

