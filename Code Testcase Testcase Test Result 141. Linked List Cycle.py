#Python:

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        turtle = head
        hare = head
        while hare and hare.next:
            turtle = turtle.next
            hare = hare.next.next
            if turtle == hare:
                return True
        return False


#Java:

public class Solution {
    public boolean hasCycle(ListNode head) {
        var turtle = head;
        var hare = head;
        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
            if(hare == turtle) return true;
        }
        return false;
    }
}
