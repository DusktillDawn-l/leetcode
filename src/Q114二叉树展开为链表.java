import java.util.ArrayList;
import java.util.List;

public class Q114二叉树展开为链表 {
    public void flatten(TreeNode root) {
        List<TreeNode> nodes= new ArrayList<TreeNode>();
        preOrder(root,nodes);
        for(int i=1;i<nodes.size();i++){
            TreeNode pre = nodes.get(i-1);
            pre.left = null;
            pre.right = nodes.get(i);
        }


    }

    public void preOrder(TreeNode root,List<TreeNode> nodes){
        if(root == null) {
            return;
        }
        nodes.add(root);
        preOrder(root.left,nodes);
        preOrder(root.right,nodes);
        return;
    }
}
