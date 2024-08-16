import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q138随机链表的复制 {
    Map<Node,Node> cashedNode = new HashMap<Node,Node>();
    public static void main(String[] args) {

    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        if(!cashedNode.containsKey(head)){
            Node headNew = new Node(head.val);
            cashedNode.put(head,headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cashedNode.get(head);
    }
}
