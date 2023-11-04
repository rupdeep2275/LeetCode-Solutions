class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        res = 0
        for num in left:
            res = max(num, res)
        for num in right:
            res = max(n - num, res)
        return res
        
