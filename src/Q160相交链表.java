public class Q160相交链表 {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null|| headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA!=pB){
            pA = pA == null? headB:pA.next;
            pB = pB == null? headA:pB.next;
        }
        return pA;
        /*
        因为两个链表长度不同，所以不好查找，目的是从两个链表剩余长度相等的位置开始查询
        如两个长度分别为5，3，则从长度3，3的位置查找能找到相同的节点，找不到就没有
        因此最好的方法是让链表a遍历A+B两个链表，让链表B也遍历A+B两个链表，这样经过遍历，这样就能保证此时两者距离重点的距离是相等的
         */
    }
}
