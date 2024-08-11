import java.util.HashMap;

public class Q560和为K的子数组 {
    public static void main(String[] args) {

    }
    public static int subarraySum(int[] nums, int k) {
        //使用前缀和和 hashmap 来减少时间复杂度
        //当 当前pre【i】-k 后的结果能在 map 中找到时，即说明之前存在字符串加上 k 等于 pre【i】，即说明中间有子串能组成 k
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int pre = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            if(map.containsKey(pre-k)){
                count += map.get(pre-k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

}
