#Python:

class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        a_minus_one, b_plus_one, curr = list1, list1, list1
        i = 0
        while i < b:
            curr = curr.next
            i += 1
            if i == a-1:
                a_minus_one = curr
        b_plus_one = curr.next
        curr = list2
        while curr.next:
            curr = curr.next
        a_minus_one.next = list2
        curr.next = b_plus_one
        return list1

#Java:

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aMinusOne = list1, bPlusOne = list1, curr = list1;
        int i = 0;
        while(i<b){
            curr = curr.next;
            i++;
            if(i==a-1){
                aMinusOne = curr;
            }
        }
        bPlusOne = curr.next;
        curr = list2;
        while(curr.next != null){
            curr = curr.next;
        }
        aMinusOne.next = list2;
        curr.next = bPlusOne;
        return list1;
    }
}
