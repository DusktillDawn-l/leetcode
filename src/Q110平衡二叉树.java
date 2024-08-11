public class Q110平衡二叉树 {


     public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
     this.left = left;
     this.right = right;
     }
     }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return dfsHeight(root) != -1;
        }

        public int dfsHeight(TreeNode node) {
            if (node == null) return 0;

            int leftHeight = dfsHeight(node.left);
            if (leftHeight == -1) return -1;  // not balanced

            int rightHeight = dfsHeight(node.right);
            if (rightHeight == -1) return -1; // not balanced

            if (Math.abs(leftHeight - rightHeight) > 1) return -1; // not balanced

            return Math.max(leftHeight, rightHeight) + 1; // return height
        }
    }
}
