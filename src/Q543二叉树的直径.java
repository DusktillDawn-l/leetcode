import java.util.ArrayList;

public class Q543二叉树的直径 {
    int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxLength;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        maxLength = Math.max(left+right,maxLength);
        return Math.max(left,right)+1;
    }
}
