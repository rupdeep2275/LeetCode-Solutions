class Solution {
    public int lengthOfLongestSubstring(String s) {
        var map = new HashMap<Character, Integer>();
        int i = 0, res = 0;
        for(int j=0; j<s.length(); j++){
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch) >= i) i = map.get(ch) + 1;
            map.put(ch, j);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
