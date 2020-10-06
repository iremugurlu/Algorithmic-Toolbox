import javax.lang.model.type.ArrayType;
import java.util.*;

public class FibonacciHuge {
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
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

