class Solution:
    def findGCD(self, nums: List[int]) -> int:
        maxx, minn = 0, 1001
        for num in nums:
            maxx = max(maxx, num)
            minn = min(minn, num)
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a%b)
        return gcd(maxx, minn)
