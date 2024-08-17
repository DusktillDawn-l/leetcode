public class Q226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        root = invert(root);
        return root;

    }
    public TreeNode invert(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
