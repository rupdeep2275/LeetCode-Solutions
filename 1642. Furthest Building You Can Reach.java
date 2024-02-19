// Java:

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        var pq = new PriorityQueue<Integer>();
        for(var i=0; i<heights.length-1; i++){
            var d = heights[i+1] - heights[i];
            if(d > 0) pq.add(d);
            if(pq.size() > ladders){
                bricks -= pq.poll();
            }
            if(bricks < 0) return i;
        }
        return heights.length - 1;
    }
}

//Python:

class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        pq = []
        for i in range(len(heights) - 1):
            d = heights[i+1] - heights[i]
            if d > 0:
                heapq.heappush(pq, d)
            if len(pq) > ladders:
                bricks -= heapq.heappop(pq)
            if bricks < 0:
                return i
        return len(heights) - 1
