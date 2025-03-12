class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, i = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j=0; j<s.length(); j++){
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch) >= i) i = map.get(ch) + 1;
            map.put(ch, j);
            res = Math.max(j - i + 1, res);
        }
        return res;
    }
}
