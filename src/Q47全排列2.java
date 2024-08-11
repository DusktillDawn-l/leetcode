import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47全排列2 {
    boolean[] vis;
    public static void main(String[] args) {


    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,ans,0,perm);
        return ans;
    }

    public void backtrack(int[] nums,List<List<Integer>> ans, int idx, List<Integer> perm){
        if(idx == nums.length){
            ans.add(new ArrayList<Integer>(perm));
            return;
        }

        for(int i=0;i<nums.length;++i){
            if(vis[i]||(i>0&&nums[i]==nums[i-1]&&!vis[i-1]))
                continue;
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums,ans,idx+1,perm);
            vis[i] = false;
            perm.remove(idx);
        }

    }

    /*
    for循环保证了从数组中从前往后一个一个取值，再用if判断条件。所以nums[i - 1]一定比nums[i]先被取值和判断。
    如果nums[i - 1]被取值了，那vis[i - 1]会被置1，只有当递归再回退到这一层时再将它置0。
    每递归一层都是在寻找数组对应于递归深度位置的值，每一层里用for循环来寻找。
    所以当vis[i - 1] == 1时，说明nums[i - 1]和nums[i]分别属于两层递归中，也就是我们要用这两个数分别放在数组的两个位置，这时不需要去重。
    但是当vis[i - 1] == 0时，说明nums[i - 1]和nums[i]属于同一层递归中（只是for循环进入下一层循环），也就是我们要用这两个数放在数组中的同一个位置上，这就是我们要去重的情况。
     */
}
