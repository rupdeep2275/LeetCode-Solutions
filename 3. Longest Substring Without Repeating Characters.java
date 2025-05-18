class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        int i = 0, res = 0;
        for(int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            if(indexMap.containsKey(c) && indexMap.get(c) >= i) i = indexMap.get(c) + 1;
            indexMap.put(c, j);
            res = Math.max(j - i + 1, res);
        }
        return res;
    }
}
