import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        if(from == to) {
            return getFibonacciHugeNaive(from, 10);
        }
        if (to <= 1)
            return to;
        if(from>=1) {
            return ((((getFibonacciSumNaive(to)-getFibonacciSumNaive(from-1))%10)+10)%10);
        }
        return ((getFibonacciSumNaive(to))%10);
    }

    private static long getFibonacciSumNaive(long n) {

        n = n % getPisonaPeriod(10);

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        if (n <= 1)
            return n;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
            sum = (sum + current) % 10;
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

    private static long getFibonacciHugeNaive(long n, long m) {

        long pisona = getPisonaPeriod(m);

        n = n%pisona;

        long previous = 0;
        long current  = 1;

        if (n <= 1)
            return n;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
        }

        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

