class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int sum = 0, maxOutlier = 0;
        for(int num : nums){
            sum += num;
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        for(int x : freqMap.keySet()){
            int rem = sum - x;
            if(rem % 2 != 0) continue;
            int s = rem / 2;
            if(freqMap.containsKey(s) && (x != s || freqMap.get(s) > 1)){
                maxOutlier = Math.max(x, maxOutlier);
            }
        }
        return maxOutlier;
    }
}
