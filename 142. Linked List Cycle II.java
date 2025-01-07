public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode s = head, f = head;
        var cycle = false;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f){
                cycle = true;
                break;
            }
        }
        if(cycle == false) return null;
        while(head != s){
            head = head.next;
            s = s.next;
        }
        return head; 
    }
}
