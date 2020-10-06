import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        Arrays.sort(segments);
        Segment curr = segments[0];
        List<Integer> points = new ArrayList<>();
        for (int i = 1; i < segments.length; i++) {
            if(curr.end >= segments[i].start) {
                curr.start = Integer.max(segments[i].start, curr.start);
                curr.end = Integer.min(segments[i].end, curr.end);
            } else {
                points.add(curr.end);
                curr = segments[i];
            }
        }
        points.add(curr.end);
        return points;
    }

    private static class Segment implements Comparable<Segment>{

        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment segment) {
            return Integer.compare(this.start, segment.start);
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
