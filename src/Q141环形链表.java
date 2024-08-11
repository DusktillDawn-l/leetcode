public class Q141环形链表 {
    public static void main(String[] args) {

    }
    public static boolean hasCycle(ListNode head) {
        //经典时尚快慢小指针，只要有环总有一天两者能相遇
        if(head == null)
            return false;
        ListNode fast = head, slow = head;
        while(slow.next != null && fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
}
