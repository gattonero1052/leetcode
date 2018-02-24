package interview.linkedlist;

import definition.ListNode;
import utils.Printer;

/**
 * Created by zly on 2018/2/24.
 * 要求原地算法
 * 注意这里的数组元素是一正一负交替的
 *
 * https://leetcode.com/problems/odd-even-linked-list/discuss/78079/Simple-O(N)-time-O(1)-space-Java-solution.?page=1
 * 这里有个逻辑上更加清晰的算法，思路应该是判断偶数指针末端的状态，可以看做一个大小为2的滑动窗口，确实更快一点
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
//        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
//        l.next.next.next.next.next = new ListNode(6);
//        l.next.next.next.next.next.next = new ListNode(7);
//        l.next.next.next.next.next.next.next = new ListNode(8);
        Printer.print(oddEvenList(l));
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null)return null;

        boolean isodd = true;
        ListNode oddStart = head,oddEnd = oddStart,evenStart = head.next,evenEnd = evenStart;

        while(head!=null){
            if(isodd && head!=oddEnd){
                oddEnd.next = head;
                oddEnd = oddEnd.next;
            }

            if(!isodd && head!=evenEnd){
                evenEnd.next = head;
                evenEnd = evenEnd.next;
            }

            isodd=!isodd;
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }

        oddEnd.next = evenStart;

        return oddStart;
    }
}
