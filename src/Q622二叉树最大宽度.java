import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q622二叉树最大宽度 {
    public static void main(String[] args) {
        return ;
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> levelNodes = new ArrayList<>();
        queue.offer(root);
        levelNodes.add(root.val);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nextLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    queue.offer(current.left);
                    queue.offer(current.right);
                    if (current.left != null) nextLevel.add(current.left.val);
                    else nextLevel.add(0);
                    if (current.right != null) nextLevel.add(current.right.val);
                    else nextLevel.add(0);
                } else {
                    queue.offer(null);
                    queue.offer(null);
                    nextLevel.add(0);
                    nextLevel.add(0);
                }
            }
            // Remove trailing zeros to check if the next level is all zeros
            while (!nextLevel.isEmpty() && nextLevel.get(nextLevel.size() - 1) == 0) {
                nextLevel.remove(nextLevel.size() - 1);
            }
            if (nextLevel.isEmpty()) break; // If next level is all zeros, it means it's the end of the tree
            levelNodes.addAll(nextLevel);
        }

        int maxWidth = 1;
        int level = 1;
        int index = 0;
        while (index < levelNodes.size()) {
            int currentWidth = 0;
            int levelNodeCount = (int)Math.pow(2, level - 1);
            for (int i = 0; i < levelNodeCount && index < levelNodes.size(); i++, index++) {
                if (levelNodes.get(index) != 0) {
                    currentWidth = i + 1;
                }
            }
            maxWidth = Math.max(maxWidth, currentWidth);
            level++;
        }
        return maxWidth;
    }
}
