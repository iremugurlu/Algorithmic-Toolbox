import java.util.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int num = 0;
        int curr = 0;
        int n = stops.length;
        int[] x = new int[n+2];
        x[0] = 0;
        x[n+1] = dist;
        for (int i = 0; i < n; i++) {
            x[i+1] = stops[i];
        }
        while(curr<=n) {
            int last = curr;
            while(curr<=n && (x[curr+1] - x[last])<=tank) {
                curr = curr + 1;
            }
            if(curr==last) {
                return -1;
            }
            if(curr<=n) {
                num+=1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
