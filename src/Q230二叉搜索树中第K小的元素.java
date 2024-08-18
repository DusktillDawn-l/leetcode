import java.util.ArrayList;
import java.util.List;

public class Q230二叉搜索树中第K小的元素 {
    //采用中序遍历的方式来获得最小的第 k 个元素
    //中序遍历后得到的节点自然而然是从小到大的
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<Integer>();
        values = inOrder(root,values);
        for(int i=0;i<values.size();i++){
            if(i==k-1)
                return values.get(i);
        }
        return 0;
    }
    public List<Integer> inOrder(TreeNode root, List<Integer> values){
        if(root == null){
            return null;
        }
        inOrder(root.left,values);
        values.add(root.val);
        inOrder(root.right,values);
        return values;
    }
}
