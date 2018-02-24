package definition;

/**
 * Created by zly on 2018/2/24.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        ListNode l = this;
        StringBuilder res = new StringBuilder();
        while(l!=null){
            res.append(l.val);
            if(l.next!=null)
                res.append("->");

            l = l.next;
        }

        return res.toString();
    }
}
