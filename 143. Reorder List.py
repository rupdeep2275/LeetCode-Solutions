#Python:

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        def reverse(head):
            prev, curr = None, head
            while curr:
                next_node = curr.next
                curr.next = prev
                prev = curr
                curr = next_node
            return prev
        def find_mid(head):
            turtle, hare = head, head
            while hare.next and hare.next.next:
                turtle = turtle.next
                hare = hare.next.next
            return turtle
        h1, mid = head, find_mid(head)
        h2 = reverse(mid.next)
        mid.next = None
        while h2:
            next1 = h1.next
            next2 = h2.next
            h1.next = h2
            h2.next = next1
            h1 = next1
            h2 = next2

#Java:

class Solution {
    public void reorderList(ListNode head) {
        ListNode h1 = head, mid = findMid(head), h2 = reverse(mid.next);
        mid.next = null;
        while(h2 != null){
            var next1 = h1.next;
            var next2 = h2.next;
            h1.next = h2;
            h2.next = next1;
            h1 = next1;
            h2 = next2;
        }
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private ListNode findMid(ListNode head){
        ListNode turtle = head, hare = head;
        while(hare.next != null && hare.next.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
        }
        return turtle;
    }
}
