class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0, day = 1, i = 0;
        while(i < events.length || !pq.isEmpty()) {
            while(i < events.length && events[i][0] <= day) {               
                pq.offer(events[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
            if(!pq.isEmpty()) {
                pq.poll();
                count++;
            }
            day++;
        }
        return count;
    }
}
