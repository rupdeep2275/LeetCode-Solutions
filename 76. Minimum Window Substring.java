class Solution {
    public String minWindow(String s, String t) {
        var map = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        var window = new HashMap<Character, Integer>();
        int i = 0, minLen = s.length() + 1, index = -1, required = map.size(), formed = 0;
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(map.containsKey(c) && window.get(c).intValue() == map.get(c).intValue()){
                formed++;
            }
            while(i <= j && formed == required){
                c = s.charAt(i);
                if(minLen > j - i + 1){
                    index = i;
                    minLen = j - i + 1;
                }
                window.put(c, window.get(c) - 1);
                if(map.containsKey(c) && window.get(c).intValue() < map.get(c).intValue()){
                    formed--;
                }
                i++;
            }
        }
        return index == -1 ? "" : s.substring(index, index + minLen);
    }
}
