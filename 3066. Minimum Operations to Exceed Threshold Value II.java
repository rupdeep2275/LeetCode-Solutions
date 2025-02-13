class Solution {
    public int minOperations(int[] nums, int k) {
        var pq = new PriorityQueue<Long>();
        for(int num : nums) pq.add((long)num);
        int res = 0;
        while(pq.size() > 1){
            if(pq.peek() >= k) break;
            long x = pq.poll(), y = pq.poll();
            pq.add(Math.min(x, y) * 2 + Math.max(x, y));
            res++;
        }
        return res;
    }
}
