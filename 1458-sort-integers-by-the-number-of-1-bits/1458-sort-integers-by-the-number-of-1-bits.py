class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        def set_bits(n):
            count = 0
            while n:
                count += (n & 1)
                n = n >> 1
            return count
        res = [0] * len(arr)
        for i in range(len(arr)):
            res[i] = set_bits(arr[i]) * 10001 + arr[i]
        res.sort()
        for i in range(len(arr)):
            res[i] = res[i] % 10001
        return res
        