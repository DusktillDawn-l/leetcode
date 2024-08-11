import java.util.ArrayList;
import java.util.Arrays;

public class Q56合并区间 {
    public static void main(String[] args) {

        int[][] myArray = {
                {1, 4},
                {4, 5}
        };
        System.out.println(merge(myArray));
    }
    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int max ,min ;
        min = intervals[0][0];
        max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][1] <min||intervals[i][0]>max) {
                ans.add(new int[]{min,max});
                min = intervals[i][0];
                max = intervals[i][1];
            }
            else {
                max = Math.max(max, intervals[i][1]);
                min = Math.min(min, intervals[i][0]);
            }
        }
        ans.add(new int[]{min,max});

        return ans.toArray(new int[ans.size()][]);
    }
}

