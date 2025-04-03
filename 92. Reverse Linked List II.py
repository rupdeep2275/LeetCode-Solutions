#Python:

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        prev, curr, n = None, head, right - left + 1
        while left > 1:
            prev = curr
            curr = curr.next
            left -= 1
        sentinel, tail, = prev, curr
        while n > 0:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
            n -= 1
        if sentinel:
            sentinel.next = prev
        else:
            head = prev
        tail.next = curr
        return head

#Java:

# /**
#  * Definition for singly-linked list.
#  * public class ListNode {
#  *     int val;
#  *     ListNode next;
#  *     ListNode() {}
#  *     ListNode(int val) { this.val = val; }
#  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
#  * }
#  */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null, curr = head;
        int n = right - left + 1;
        while(left-->1){
            prev = curr;
            curr = curr.next;
        }
        ListNode sentinel = prev, tail = curr;
        while(n-->0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        tail.next = curr;
        if(sentinel != null) sentinel.next = prev;
        else head = prev;

        return head;
    }
}
