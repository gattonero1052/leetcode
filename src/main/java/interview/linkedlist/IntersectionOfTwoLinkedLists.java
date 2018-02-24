package interview.linkedlist;

import definition.ListNode;
import utils.Printer;

/**
 * Created by zly on 2018/2/24.
 *
 * 要求原地算法
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode c = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = c;
        b.next = c;

        Printer.print(getIntersectionNode(a,b));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headAEnd = headA,headBEnd = headB;
        int alen=0,blen=0;

        while(headAEnd!=null){
            headAEnd = headAEnd.next;
            alen++;
        }

        while(headBEnd!=null){
            headBEnd = headBEnd.next;
            blen++;
        }

        headAEnd = headA;
        headBEnd = headB;

        if(alen>blen){
            while(alen-blen>0){
                headAEnd = headAEnd.next;
                alen--;
            }
        }

        if(alen<blen){
            while(blen-alen>0){
                headBEnd = headBEnd.next;
                blen--;
            }
        }

        while(headAEnd!=null && headBEnd!=null){
            if(headAEnd==headBEnd)
                return headAEnd;

            headAEnd = headAEnd.next;
            headBEnd = headBEnd.next;
        }

        return null;
    }
}
