import java.util.ArrayList;
import java.util.Collections;

public class Q143重排链表 {
    public static void main(String[] args) {

    }

    public static void reorderList(ListNode1 head) {
        ArrayList<ListNode1> smallNodes = new ArrayList<>();
        ArrayList<ListNode1> largeNodes = new ArrayList<>();
        int length = 0;
        ListNode1 p = new ListNode1();
        p = head;
        while(p!= null){
            length++;
            p = p.next;
        }
        p = head;
        for (int i = 0; i < length/2; i++) {
            smallNodes.add(p);
            p = p.next;
        }

        for (int i = length/2+1; i < length; i++) {
            largeNodes.add(p);
            p = p.next;
        }
        Collections.reverse(largeNodes);
        head = smallNodes.get(0);
        for (int i = 0; i <length/2-1; i++) {
            head.next = largeNodes.get(i);
            head = head.next;
            head.next = smallNodes.get(i+1);
        }
        head = head.next;
        head.next = largeNodes.get(largeNodes.size()-1);

    }

}
