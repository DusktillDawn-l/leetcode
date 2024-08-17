public class Q104二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else{
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
}
