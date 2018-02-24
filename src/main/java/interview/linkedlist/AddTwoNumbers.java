package interview.linkedlist;

import definition.ListNode;
import utils.Printer;

/**
 * Created by zly on 2018/2/24.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        Printer.print(addTwoNumbers(l1,l2).toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int div = 0;
        ListNode res = null;
        ListNode cur = null;

        while(l1!=null && l2!=null){
            if(cur == null){
                cur = new ListNode(0);
                res = cur;
            }else{
                cur.next = new ListNode(0);
                cur = cur.next;
            }

            cur.val = (l1.val+l2.val+div) % 10;
            div = (l1.val+l2.val+div) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode l = l1==null?l2:l1;
        while(l!=null || div>0){
            cur.next = new ListNode(0);
            cur = cur.next;

            if(l==null){
                cur.val = 1;
                div = 0;
            }else{
                cur.val = (div+l.val) %10;
                div = (div+l.val)/10;
                l = l.next;
            }
        }

        return res;
    }
}
