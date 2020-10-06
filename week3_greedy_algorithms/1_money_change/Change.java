import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int ten = m/10;
        int five = (m%10)/5;
        int one = m - ten*10-five*5;
        return ten+five+one;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

