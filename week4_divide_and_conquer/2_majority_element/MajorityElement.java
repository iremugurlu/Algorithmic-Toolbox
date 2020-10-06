import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        Arrays.sort(a);
        int middle = a[left+(right-left)/2];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == middle) {
                count++;
            }
        }
        if(count>left+(right-left)/2) {
            return a[left+(right-left)/2];
        } else {
            return -1;
        }
    }

    private static int getMajorityElementQuadratic(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int curr = a[i];
            int count = 0;
            for (int j = 1; j < a.length; j++) {
                if(a[j] == curr) {
                    count+=1;
                }
            }
            if(count>a.length/2) {
                return a[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

