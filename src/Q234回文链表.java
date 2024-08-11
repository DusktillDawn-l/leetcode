import java.util.ArrayList;

public class Q234回文链表 {
    public static void main(String[] args) {

    }
    public static boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> numbers = new ArrayList<ListNode>();
        ListNode cur = head;
        while(cur!=null){
            numbers.add(cur);
            cur = cur.next;
        }
        int length = numbers.size();
        // if(length%2!=0)
        //     return false;
        for(int i = 0,j = length-1;i<length;i++,j--)
        {
            if(numbers.get(i).val!=numbers.get(j).val){
                return false;
            }
        }
        return true;
    }
}
