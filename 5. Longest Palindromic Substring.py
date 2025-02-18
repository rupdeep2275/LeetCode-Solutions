class Solution:
    def longestPalindrome(self, s: str) -> str:
        max_len, index = 0, -1
        def get_starting_index_and_length(s, lo, hi):
            nonlocal max_len, index
            while lo >= 0 and hi < len(s) and s[lo] == s[hi]:
                lo -= 1
                hi += 1
            if hi - lo - 1 > max_len:
                max_len = hi - lo - 1
                index = lo + 1
        for i in range(len(s)):
            get_starting_index_and_length(s, i, i)
            get_starting_index_and_length(s, i, i+1)
        return s[index : index + max_len]

        

class Solution {
    int len, idx;
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++){
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return s.substring(idx, idx+len);
    }
    void expand(String s, int i, int j){
        while(i >= 0 && j <s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if(j-i-1>len){
            len = j-i-1;
            idx = i+1;
        }
    }
}
