import java.util.HashSet;

public class Q142环形链表2 {
    public static void main(String[] args) {

    }
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head,slow = head;
        while(true){
            if(fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        fast = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
