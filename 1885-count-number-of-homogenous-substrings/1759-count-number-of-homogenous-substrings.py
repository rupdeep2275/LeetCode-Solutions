class Solution:
    def countHomogenous(self, s: str) -> int:
        res = 0
        mod = 1_000_000_007
        streak = 0
        for i in range(len(s)):
            if i == 0 or s[i] == s[i-1]:
                streak += 1
            else:
                streak = 1
            res = (res + streak) % mod
        return res
        
