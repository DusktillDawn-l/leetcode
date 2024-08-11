public class Q213打家劫舍2 {
    public static void main(String[] args) {
//        int[] money = {2, 3, 1};
//        int[] money1 = {1,2,3,1};
        int[] money2 = {1,2,3,1};
//        System.out.println(rob(money));
//        System.out.println(rob(money1));
        System.out.println(rob(money2));
    }

    public static int rob(int[] nums) {
        int money = 0;
        int length = nums.length;
        if (length == 0)
            return 0;
        if (length == 1)
            return nums[0];
        if (length==2)
            return Math.max(nums[0],nums[1]);
        else
            return Math.max(robRange(nums,0,length-1),robRange(nums,1,length));
    }
//    public static int robRange(int[] nums, int start, int end) {
//        if(start == end){
//            return nums[start];
//        }
//        int[] dp = new int[nums.length];
//        dp[start] = nums[start];
//        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
//        for (int i = start + 2; i <= end; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//        }
//        return dp[end];
//    }
    public static int robRange(int[] nums,int start,int end){
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start+2; i < end; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[end-1];
    }
}
