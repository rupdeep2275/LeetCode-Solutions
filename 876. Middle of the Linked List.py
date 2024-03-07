#Python:

class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        turtle, hare = head, head
        while hare and hare.next:
            turtle = turtle.next
            hare = hare.next.next
        return turtle


#Java:

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode turtle = head, hare = head;
        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
        }
        return turtle;
    }
}
