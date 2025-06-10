class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        int max = 0, min = 100;
        for(int val : freqMap.values()){
            if(val % 2 != 0) max = Math.max(val, max);
            else min = Math.min(val, min);
        }
        return max - min;
    }
}
