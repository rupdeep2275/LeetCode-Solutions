class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int i = 0, n = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            n++;
        }
        curr = head;
        int size = n/k, rem = n%k;
        ListNode[] res = new ListNode[k];
        ListNode prev = null;
        while(i < k && curr != null){
            res[i] = curr;
            for(var j=0; curr != null && j < size + (rem > 0 ? 1 : 0); j++){
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            rem--;
            i++;
        }
        return res;
    }
}
