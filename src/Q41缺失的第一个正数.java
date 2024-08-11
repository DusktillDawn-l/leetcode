import java.util.HashSet;

public class Q41缺失的第一个正数 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,0};
        int[] nums2 = new int[]{3,4,-1,1};
        int[] nums3 = new int[]{7,8,9,11,12};

        System.out.println(firstMissingPositive(nums1));
        System.out.println(firstMissingPositive(nums2));
        System.out.println(firstMissingPositive(nums3));
    }
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: 将每个正整数 nums[i] 放到索引为 nums[i] - 1 的位置上
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: 寻找第一个索引 i，使得 nums[i] != i + 1，即缺失的最小正整数为 i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果数组中的所有数字都在正确的位置上，则返回 n + 1
        return n + 1;
    }
}
