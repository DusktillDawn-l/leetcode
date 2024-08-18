import java.util.*;

public class Q199二叉树的右视图 {
    List<Integer> ret = new ArrayList<Integer>();
    Deque<TreeNode> ans = new LinkedList<TreeNode>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return ret;
        ans.add(root);
        bfs(root);
        return ret;
    }
    public void bfs(TreeNode root){
        while (!ans.isEmpty()) {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = ans.poll();
                if (node != null) {
                    if (i == size - 1) {
                        ret.add(node.val);
                    }
                    if (node.left != null) {
                        ans.offer(node.left);
                    }
                    if (node.right != null) {
                        ans.offer(node.right);
                    }
                }
            }
        }
    }
}
