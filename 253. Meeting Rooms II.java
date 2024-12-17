//Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

// Example 1:
// Input: intervals = [[0,30],[5,10],[15,20]]
// Output: 2

// Example 2:
// Input: intervals = [[7,10],[2,4]]
// Output: 1

import java.util.*;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0; // No meetings, no rooms required
        }

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Use a priority queue (min-heap) to track end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 3: Iterate through the intervals
        for (int[] interval : intervals) {
            // If the room with the earliest end time is free, remove it
            if (!minHeap.isEmpty() && minHeap.peek() <= interval[0]) {
                minHeap.poll(); // Free the room
            }
            // Add the current meeting's end time to the heap
            minHeap.add(interval[1]);
        }

        // The size of the heap is the number of rooms required
        return minHeap.size();
    }
}
