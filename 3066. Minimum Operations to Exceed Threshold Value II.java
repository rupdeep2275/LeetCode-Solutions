class Solution {
    public int minOperations(int[] nums, int k) {
        var pq = new PriorityQueue<Long>();
        for(int num : nums) pq.add((long)num);
        int res = 0;
        while(pq.size() > 1){
            if(pq.peek() >= k) break;
            pq.add(pq.poll() * 2 + pq.poll());
            res++;
        }
        return res;
    }
}
