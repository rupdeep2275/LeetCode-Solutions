#Python:

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x : x[0])
        merged = []
        for interval in intervals:
            if not merged or merged[-1][1] < interval[0]:
                merged.append(interval)
            else:
                merged[-1][1] = max(merged[-1][1], interval[1])
        return merged

#Java:

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }
            else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}


# Simple Intuitive:

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] <= end) end = Math.max(intervals[i][1], end);
            else{
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}
