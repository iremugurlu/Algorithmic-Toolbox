import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {

        int n = numbers.length;

        int index_1 = -1;

        for (int i = 0; i < n; ++i) {
            if(index_1 == -1 || numbers[i]>numbers[index_1]) {
                index_1 = i;
            }
        }

        int index_2 = -1;

        for (int i = 0; i < n; ++i) {
            if((i != index_1) && (index_2 == -1 || numbers[i]>numbers[index_2])) {
                index_2 = i;
            }
        }

        return ((long) numbers[index_1]) * numbers[index_2];
    }

    static long getMaxPairwiseProductShort(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                        ((long) numbers[first]) * numbers[second]);
            }
        }

        return max_product;
    }

    public static void main(String[] args) {
        stressTest();
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    public static void stressTest() {
        while(true) {
            int n = (int) (Math.random()*1000) + 2;
            System.out.println(n);
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = (int) (Math.random()*100000);
            }
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            long res1 = getMaxPairwiseProductShort(a);
            long res2 = getMaxPairwiseProduct(a);
            if(res1!=res2) {
                System.out.println("Wrong answer " + res1 + " " + res2);
                break;
            } else {
                System.out.println("OK!");
            }
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
