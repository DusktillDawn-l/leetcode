import java.util.Arrays;

public class Q977有序数组的平方 {
    public static void main(String[] args) {
        int[] nums = new int[]{-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            nums[i] = Math.abs(nums[i]);
        }
        nums = quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }
    public static int[] quickSort(int[] nums,int low, int high){
        if(low<high){
            int p = partiotion(nums,low,high);
            quickSort(nums,low,p-1);
            quickSort(nums,p+1,high);
        }
        return nums;
    }
    public static int partiotion(int[] nums, int low, int high) {
        int p = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= p)
                --high;
            nums[low] = nums[high];
            while (low < high && nums[low] <= p)
                ++low;
            nums[high] = nums[low];
        }
        nums[low] = p;
        return low;
    }

}
