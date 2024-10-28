class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<Long>(), visited = new HashSet<Long>();
        var res = -1;
        for (int num : nums) set.add(num * 1L); 
        // Arrays.sort(nums); 

        for (var num : nums) {
            long current = num;
            if (visited.contains(current)) continue;
            var length = 1; 

            while (set.contains(current * current)) {
                visited.add(current);  
                current = current * current;  
                length++;
            }

            if (length > 1) res = Math.max(res, length);
        }

        return res;
    }
}

//video explanation: https://youtu.be/XRZOSU5p4q4
