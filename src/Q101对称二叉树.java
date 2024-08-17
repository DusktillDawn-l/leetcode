import com.sun.source.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        Stack<Object> objects = new Stack<>();
        return compare(root,root);
    }

    public boolean compare(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;

        }
        if(p == null || q == null){
            return false;
        }
        if(!compare(p.left,q.right)){
            return false;
        }
        if(!compare(p.right,q.left)){
            return false;
        }
        return p.val == q.val;
    }
}
