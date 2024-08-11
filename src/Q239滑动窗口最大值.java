import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q239滑动窗口最大值 {
    public static void main(String[] args) {
        int[] arr1 = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr1, 3)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
                //升序前-后，降序后-前

            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i],i});
        }

        int[] ans = new int[nums.length-k+1];
        ans[0] = pq.peek()[0];
        for(int i=k;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
            //获取堆顶元素的索引，如果这个索引小于或等于 i - k，说明这个元素已经不在当前窗口内，需要移除。
            while (pq.peek()[1] <= i - k) {
                pq.poll();
                //移除堆顶元素。
                //这一步确保了优先队列中的元素都是当前窗口内的元素。
            }
            ans[i-k+1] = pq.peek()[0];
        }

        return ans;

    }
}
