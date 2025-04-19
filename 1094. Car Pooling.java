class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        int curr = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.to - b.to);
        for(int[] trip : trips){
            while(!pq.isEmpty() && pq.peek().to <= trip[1]){
                curr -= pq.poll().p;
            }
            curr += trip[0];
            if(curr > capacity) return false;
            pq.add(new Pair(trip[0], trip[2]));
        }
        return true;
    }
}
class Pair{
    int p, to;
    Pair(int p, int to){
        this.p = p;
        this.to = to;
    }
}
