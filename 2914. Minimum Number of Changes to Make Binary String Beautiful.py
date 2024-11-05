#Python:

class Solution:
    def minChanges(self, s: str) -> int:
        res, i = 0, 0
        while i < len(s) - 1:
            if s[i] != s[i+1]:
                res += 1
            i += 2
        return res

#Java:

class Solution {
    public int minChanges(String s) {
        var res = 0;
        for(var i=0; i<s.length(); i++){
            if(s.charAt(i) != s.charAt(i+1)) res++;
            i++;
        }
        return res;
    }
}
