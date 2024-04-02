class Solution {
    public boolean isIsomorphic(String s, String t) {
        var map1 = new HashMap<Character, Integer>();
        var map2 = new HashMap<Character, Integer>();
        for(Integer i=0; i<s.length(); i++){
            if(map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i)) return false;
        }
        return true;
    }
}
