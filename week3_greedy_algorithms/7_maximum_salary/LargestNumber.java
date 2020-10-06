import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        int[] numbers = new int[a.length];
        ArrayList<Integer>[] nums = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < a.length; i++) {
            numbers[i] = Integer.valueOf(a[i]);
            nums[firstDigit(numbers[i])].add(numbers[i]);
        }
        for (int i = 9; i >= 1; i--) {
            if(nums[i].size()>0) {
                nums[i] = sortList(nums[i]);
                for(int j=0; j<nums[i].size(); j++) {
                    result += nums[i].get(j);
                }
            }
        }
        return result;
    }

    private static ArrayList<Integer> sortList(ArrayList<Integer> num) {
        int size = num.size();
        for(int i=0; i<size; i++) {
            for(int j=i+1; j<size; j++) {
                if(Integer.valueOf(num.get(i) + "" + num.get(j))<Integer.valueOf(num.get(j) + "" + num.get(i))) {
                    int per = num.get(i);
                    num.set(i, num.get(j));
                    num.set(j, per);
                }
            }
        }
        return num;
    }

    public static int firstDigit(int n)  {
        while (n >= 10)
            n /= 10;

        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

