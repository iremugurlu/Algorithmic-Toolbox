import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        int size = values.length;
        Loot[] loots = new Loot[size];
        for(int i=0; i<size; i++) {
            loots[i] = new Loot(values[i], weights[i], i);
        }
        Arrays.sort(loots);
        for (int i = 0; i < size ; i++) {
            if(capacity == 0) {
                return value;
            }
            int a = Math.min(weights[loots[i].index], capacity);
            value += a*(loots[i].fraction);
            weights[loots[i].index] -= a;
            capacity -= a;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        return Double.valueOf(decimalFormat.format(value));
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}

class Loot implements Comparable<Loot> {

    public int value;

    public int weight;

    public int index;

    public double fraction;

    public Loot(int value, int weight, int index) {
        this.value = value;
        this.weight = weight;
        this.index = index;
        this.fraction = (double) value/weight;
    }

    @Override
    public int compareTo(Loot other) {
        return Double.compare(other.fraction, fraction);
    }
}
