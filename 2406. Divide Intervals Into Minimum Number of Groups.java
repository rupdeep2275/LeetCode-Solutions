class Solution {
    public int minGroups(int[][] intervals) {
        var pq1 = new PriorityQueue<Integer>();
        var pq2 = new PriorityQueue<Integer>();
        int pf = 0, res = 0;
        for(var i : intervals){
            pq1.add(i[0]); pq2.add(i[1]);
        }
        while(!pq1.isEmpty()){
            if(pq1.peek() <= pq2.peek()){
                pf++;
                pq1.poll();
            }
            else{
                pf--;
                pq2.poll();
            }
            res = Math.max(pf, res);
        }
        return res;
    }
}
