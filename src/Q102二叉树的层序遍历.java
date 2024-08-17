import java.util.ArrayList;
import java.util.List;

public class Q102二叉树的层序遍历 {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<TreeNode> level = new ArrayList<TreeNode>();
        if(root==null)
            return ret;
        level.add(root);
        bfs(level);
        return ret;
    }
    public void bfs(List<TreeNode> level){
        if(level.size()==0){
            return;
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(TreeNode node:level){
            ans.add(node.val);
        }
        if(ans.size()!=0){
            ret.add(ans);
        }
        List<TreeNode> nextLevel = new ArrayList<TreeNode>();
        for(TreeNode root: level){
            if(root.left!=null){
                nextLevel.add(root.left);
            }
            if(root.right!=null){
                nextLevel.add(root.right);
            }
        }
        bfs(nextLevel);
    }
}
/*
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        //使用 queue 是相比 arraylist 更好的选择
        //Deque（双端队列）在循环中一边减少一边增加是更合适的，而 ArrayList 则不太适合这种操作。
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
}

 */
