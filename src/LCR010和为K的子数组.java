import java.util.HashMap;

public class LCR010和为K的子数组 {
    public static void main(String[] args) {
        int[] num1 = {1,1,1};
        int[] num2 = {1,2,3};
        int[] num3 = {1,-1,0};
        int[] num4 = {0,0};
        System.out.println(subarraySum(num3,0));
        System.out.println(subarraySum(num1,2));
        System.out.println(subarraySum(num2,3));
        System.out.println(subarraySum(num4,0));

    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


//    public static int subarraySum(int[] nums, int k) {
//        int length = nums.length;
//        int count = 0;
//        int temp;
//        for (int i = 0; i < length; i++) {
//            temp=0;
//            for (int j = i; j < length; j++) {
//                temp+=nums[j];
//                if(temp == k)
//                    count++;
//            }
//        }
//        return count;
//    }
}
