import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int n = s.length();
    int m = t.length();
    int[][] D = new int[n+1][m+1];
    for (int i = 0; i <= n ; i++) {
      D[i][0] = i;
    }
    for (int j = 0; j <= m ; j++) {
      D[0][j] = j;
    }
    for (int j = 1; j <= m; j++) {
      for (int i = 1; i <= n; i++) {
        int insertion = D[i][j-1] + 1;
        int deletion = D[i-1][j] + 1;
        int match = D[i-1][j-1];
        int mismatch = D[i-1][j-1] + 1;
        if(s.charAt(i-1) == t.charAt(j-1)) {
          D[i][j] = Integer.min(Integer.min(insertion, deletion), match);
        } else {
          D[i][j] = Integer.min(Integer.min(insertion, deletion), mismatch);
        }
      }
    }
    return D[n][m];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
