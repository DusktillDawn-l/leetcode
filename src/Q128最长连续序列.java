import java.util.Arrays;
import java.util.HashSet;

public class Q128最长连续序列 {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int[] nums1 = {};
        System.out.println(longestConsecutive(nums));

    }

    public static int longestConsecutive(int[] nums) {
        int maxCount = 0;
        int count;
        HashSet<Integer> set =new HashSet<Integer>();
        for(int num:nums){
            set.add(num);
        }
        for(int num:set){
            int currentNum = num;
            int currentCount = 1;
            while(set.contains(currentNum+1)){
                currentCount++;
                currentNum++;
            }
            maxCount = Math.max(currentCount,maxCount);
        }
        return maxCount;
//        if(nums.length == 0) return 0;
//
//        Arrays.sort(nums);
//        int maxCount = 1;
//        int count = 1;
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == (nums[i - 1]+1)) {
//                count+=1;
//            }
//            else if(nums[i] == nums[i-1]){
//                continue;
//            }
//            else{
//                count = 1;
//            }
//            maxCount = Math.max(maxCount, count);
//        }
//        return maxCount;
    }
}
