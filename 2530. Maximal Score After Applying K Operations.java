class Solution {
    public long maxKelements(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>((a,b)->b-a);
        long res = 0;
        for(var num : nums) pq.add(num);
        while(k-->0){
            var max = pq.poll();
            res += max;
            pq.add((int)Math.ceil(max/3.0));
        }
        return res;
    }
}
