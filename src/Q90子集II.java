import java.util.ArrayList;
import java.util.List;

public class Q90子集II {
    public static void main(String[] args) {
        subsetsWithDup(new int[]{1, 2, 2});
    }
    public static  List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(nums[i]);
            if (!ret.contains(integers)){
                ret.add(new ArrayList<>(integers));
            }

            for (int j = i + 1; j < nums.length; j++) {
                integers.add(nums[j]);
                if (!ret.contains(integers)){
                    ret.add(new ArrayList<>(integers));
                }
            }
        }
        return ret;
    }
}
