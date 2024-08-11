import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Q503下一个更大元素2 {
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            for (int j = i + 1; j%nums.length!=i; j++) {
                if(nums[j% nums.length]>current){
                    res[i] = nums[j% nums.length];
                    break;
                }
            }

        }
        return res;
    }
    //使用单调栈，更好的写法
    public int[] nextGreaterElementsBetter(int[] nums){
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret,-1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i=0; i<n*2-1;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i%n]){
                //从栈中不断弹出比当前遍历到的小的值的索引
                //并把当前遍历到的值存到弹出的索引中
                ret[stack.pop()] = nums[i%n];
            }
            stack.push(i%n);//将当前索引压入栈中寻找之后比它大的
        }
        return ret;
    }






    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElements(ints)));

    }
}

