public class Q53最大子数组和 {
    public static void main(String[] args) {
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] ints2 = {5,4,-1,7,8};
        System.out.println(maxSubArray(ints));
        System.out.println(maxSubArray(ints2));

    }

    public static int  maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            currentSum = Math.max(0, currentSum);

        }
        return maxSum;
    }
}
