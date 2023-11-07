class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for(int i=0;i<dist.length; i++){
            pq.add((double)dist[i]/speed[i]);
        }
        int res = 0;
        while(!pq.isEmpty()){
            if(pq.poll() <= res){
                break;
            }
            res++;
        }
        return res;
    }
}
