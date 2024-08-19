import java.util.HashMap;
import java.util.Map;

public class Q105从前序与中序遍历序列构造二叉树 {
    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode myBuildTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if(preorder_left>preorder_right){
            return null;
        }
        int preorder_root = preorder_left;
        int inorder_root = indexMap.get(preorder[preorder_root]);
        TreeNode root = new TreeNode(preorder[preorder_root]);
        int size_left_subtree = inorder_root - inorder_left;
        root.left = myBuildTree(preorder,inorder,preorder_left+1,preorder_left+size_left_subtree,inorder_left,inorder_root-1);
        root.right = myBuildTree(preorder,inorder,preorder_left+1+size_left_subtree,preorder_right,inorder_root+1,inorder_right);
        return root;

    }
}
