import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] steps = new int[n+1];
        List<Integer> output = new ArrayList<>();
        steps[1] = 0;
        for(int i=2; i<=n; i++) {
            int result = Integer.MAX_VALUE;
            int best = 0;
            if(i%3==0) {
                if(result > (steps[i/3]+1)) {
                    result = steps[i/3]+1;
                    best = 3;
                }
            }
            if(i%2==0) {
                if(result > (steps[i/2]+1)) {
                    result = steps[i/2]+1;
                    best = 2;
                }
            }
            if(result > (steps[i-1]+1)) {
                best = 1;

            }
            if(best==1) {
                steps[i] = steps[i-1]+1;

            } else {
                steps[i] = steps[i/best] + 1;
            }
        }
        int num = n;
        output.add(n);
        while(num>1) {
            if(num%3==0 && steps[num] == steps[num/3]+1) {
                output.add(num/3);
                num = num/3;
            } else if(num%2 ==0 && steps[num] == steps[num/2]+1) {
                output.add(num/2);
                num = num/2;
            } else {
                output.add(num-1);
                num = num - 1;
            }
        }
        Collections.reverse(output);
        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

