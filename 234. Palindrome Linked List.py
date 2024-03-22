#Python:

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
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
        if head is None or head.next is None:
            return True
        h1, h2 = head, reverse(find_mid(head).next)
        while h2:
            if h1.val != h2.val:
                return False
            h1 = h1.next
            h2 = h2.next
        return True


#Java:

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true; 
        ListNode head1 = head, head2 = reverse(findMid(head).next);
        while(head2 != null){
            if(head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
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
