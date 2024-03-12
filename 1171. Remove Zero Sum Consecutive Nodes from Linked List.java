//Java:

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        var map = new HashMap<Integer, ListNode>();
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        var preSum = 0;
        for(var node = sentinel; node != null; node = node.next){
            preSum += node.val;
            map.put(preSum, node);
        }
        preSum = 0;
        for(var node = sentinel; node != null; node=node.next){
            preSum += node.val;
            node.next = map.get(preSum).next;
        }
        return sentinel.next;
    }
}

//Python:

class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        map = {}
        sentinel = ListNode(0)
        sentinel.next = head
        pre_sum = 0
        node = sentinel
        while node:
            pre_sum += node.val
            map[pre_sum] = node
            node = node.next
        pre_sum = 0
        node = sentinel
        while node:
            pre_sum += node.val
            node.next = map[pre_sum].next
            node = node.next
        return sentinel.next
