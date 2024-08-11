import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
//
//public class Q113路径总和 {
//    static ArrayList<List<Integer>> ans= new ArrayList<List<Integer>>();
//
//      public static class TreeNode {
//          int val;
//          TreeNode left;
//          TreeNode right;
//          TreeNode() {}
//          TreeNode(int val) { this.val = val; }
//          TreeNode(int val, TreeNode left, TreeNode right) {
//              this.val = val;
//              this.left = left;
//              this.right = right;
//         }
//     }
//
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(2);
//        System.out.println(pathSum(root,4));
//    }
//    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        if(root==null){
//            return new ArrayList<List<Integer>>();
//        }
//
//        int currentSum = 0;
//        dfs(root,currentSum,targetSum,new ArrayList<Integer>());
//        return ans;
//    }
//    public static void dfs(TreeNode currentNode, int currentSum, int targetSum,ArrayList<Integer> path){
//
//        currentSum += currentNode.val;
//        path.add(currentNode.val);
//
//        if(currentNode.left==null && currentNode.right==null&&currentSum==targetSum) {
//            ans.add(path);
//        }
//
//        if(currentNode.left!=null){
//            dfs(currentNode.left,currentSum,targetSum,path);
//        }
//        if(currentNode.right!=null){
//            dfs(currentNode.right,currentSum,targetSum,path);
//        }
//
//        path.remove(path.size()-1);//回溯
//    }
//
//
//}

//以下为gpt优化过后的答案
public class Q113路径总和 {
    static ArrayList<List<Integer>> ans = new ArrayList<>();

    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        System.out.println(pathSum(root, 4));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans.clear(); // 清空之前的结果
        if (root == null) {
            return ans;
        }
        dfs(root, targetSum, new ArrayList<>(), 0);
        return ans;
    }

    public static void dfs(TreeNode currentNode, int targetSum, List<Integer> path, int currentSum) {
        if (currentNode == null) {
            return;
        }

        currentSum += currentNode.val;
        path.add(currentNode.val);

        // Check if it's a leaf node and if path sum equals targetSum
        if (currentNode.left == null && currentNode.right == null && currentSum == targetSum) {
            ans.add(new ArrayList<>(path)); // Add a copy of the current path to results
        }

        // Continue to search in left and right subtrees
        dfs(currentNode.left, targetSum, path, currentSum);
        dfs(currentNode.right, targetSum, path, currentSum);

        // Backtrack: remove the current node from the path
        path.remove(path.size() - 1);
    }
}