import java.util.ArrayList;
import java.util.List;

public class Q94二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root,res);
        return res;

    }

    public void inorder(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);

    }
}
