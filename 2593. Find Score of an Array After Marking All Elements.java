class Solution {
    public long findScore(int[] nums) {
        var set = new HashSet<Integer>();
        var pq = new PriorityQueue<Pair>((a, b) -> a.num == b.num ? a.idx - b.idx : a.num - b.num);
        long res = 0;
        for(var i=0; i<nums.length; i++) pq.add(new Pair(nums[i], i));
        while(!pq.isEmpty()){
            var p = pq.poll();
            res += p.num;
            Collections.addAll(set, p.idx, p.idx + 1, p.idx - 1);
            while(!pq.isEmpty() && set.contains(pq.peek().idx)) pq.poll();
        }
        return res;
    }
}
class Pair{
    int num;
    int idx;
    Pair(int num, int idx){
        this.num = num;
        this.idx = idx;
    }
}
