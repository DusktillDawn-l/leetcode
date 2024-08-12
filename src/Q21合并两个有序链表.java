public class Q21合并两个有序链表 {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head,ptr;
        if(list1 == null)
            return list2;
        else if(list2 == null){
            return list1;
        }
        else if(list1.val<list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }
        ptr = head;

        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
                ptr.next = list2;
                list2 = list2.next;
            }
            else{
                ptr.next = list1;
                list1 = list1.next;
            }
            ptr = ptr.next;
        }
        ptr.next = list1 == null?list2:list1;
        return head;
    }
}
