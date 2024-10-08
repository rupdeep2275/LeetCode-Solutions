class Solution:
    def minSwaps(self, s: str) -> int:
        extra_closing, maxx = 0, 0
        for ch in s:
            if ch == ']':
                extra_closing += 1
            else:
                extra_closing -= 1
            maxx = max(extra_closing, maxx)
        return (maxx + 1)//2
