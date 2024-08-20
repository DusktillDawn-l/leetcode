import java.util.ArrayList;
import java.util.List;

public class Q46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums,new ArrayList<>(),result);
        return result;
    }
    public void backTrack(int[] nums, List<Integer> current, List<List<Integer>> result){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int num:nums){
            if(current.contains(num)){
                continue;
            }
            current.add(num);
            backTrack(nums,current,result);
            current.remove(current.size()-1);
        }
        //第 n 层递归考虑第 n 个元素
        //如第一层递归考虑第一个元素从 1 到 n 的选择
        // 第二层递归考虑第二个元素从 1 到 n 的选择
    }
}
