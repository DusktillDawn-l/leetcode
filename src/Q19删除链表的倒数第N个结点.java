import java.util.Deque;
import java.util.LinkedList;

public class Q19删除链表的倒数第N个结点 {
    public static void main(String[] args) {

    }


     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode ptr = dummy;
        Deque<ListNode> stack = new LinkedList<ListNode>();
        while(ptr!=null){
            stack.push(ptr);
            ptr = ptr.next;
        }
        for(int i=0;i<n;i++){
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        ListNode ans = dummy.next;
        return ans;
        //自己写的笨比方法,不加哑节点就等着吃亏吧
//        if(head==null||head.next==null){
//            return null;
//        }
//        ListNode ptr = head;
//        int length = 1;
//        while(ptr.next!=null){
//            ptr = ptr.next;
//            length++;
//        }
//        if(length==n){
//            return head.next;
//        }
//        int iter = length-n;
//        ptr = head;
//        ListNode pre = ptr;
//        while(iter>0){
//            --iter;
//            pre = ptr;
//            ptr = ptr.next;
//        }
//        if(ptr.next == null){
//            pre.next=null;
//        }
//        else{
//            pre.next = ptr.next;
//        }
//        return head;
    }
}
