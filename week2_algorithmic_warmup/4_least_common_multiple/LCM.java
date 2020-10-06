import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long lcm_effective(int a, int b) {
    int gcd = gcd_effective(a, b);
    long x = a/gcd;
    return x*b;
  }

  private static int gcd_effective(int a, int b) {
    if(a<b) {
      int temp_a = a;
      a = b;
      b = temp_a;
    }
    if(b == 0) {
      return a;
    } else {
      int rem = a%b;
      return gcd_effective(b, rem);
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    System.out.println(lcm_effective(a, b));
  }
}
