public class Q437路径总和3 {
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) return 0;

        // 从当前节点开始查找路径
        int count = inOrder(root, targetSum);

        // 继续查找左子树和右子树
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);

        return count;
    }

    private int inOrder(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        long val = root.val;
        int count = 0;

        // 如果当前路径和等于目标和，增加计数
        if (val == targetSum) {
            count++;
        }

        // 继续查找左子树和右子树
        count += inOrder(root.left, targetSum-val);
        count += inOrder(root.right, targetSum-val);
        return count;
    }
}
