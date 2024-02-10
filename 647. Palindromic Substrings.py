#Python:

class Solution:
    def countSubstrings(self, s: str) -> int:
        def helper(i, j, s):
            if i < 0 or j == len(s):
                return 0
            if s[i] == s[j]:
                return helper(i-1, j+1, s) + 1
            return 0
        res = 0
        for i in range(0, len(s)):
            res += helper(i, i, s) + helper(i, i+1, s)
        return res

#Java:

class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i=0; i<s.length(); i++){
            res += helper(i, i, s) + helper(i, i+1, s);
        }
        return res;
    }
    private int helper(int i, int j, String s){
        if(i < 0 || j == s.length()) return 0;
        if(s.charAt(i) == s.charAt(j)) return 1 + helper(i-1, j+1, s);
        return 0;
    }
}
