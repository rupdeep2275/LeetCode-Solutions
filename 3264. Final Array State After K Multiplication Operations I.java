class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        var pq = new PriorityQueue<Pair>((a, b) -> a.val == b.val ? a.idx - b.idx : a.val - b.val);
        for(var i=0; i<nums.length; i++){
            pq.add(new Pair(nums[i], i));
        }
        while(k-->0){
            var p = pq.poll();
            nums[p.idx] = multiplier * nums[p.idx];
            pq.add(new Pair(nums[p.idx], p.idx));
        }
        return nums;
    }
}
class Pair{
    int val, idx;
    Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}
