class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        n = len(dist)
        arrival = []
        for i in range(n):
            arrival.append(dist[i] / speed[i])
        arrival.sort()
        res = 0
        for i in range(n):
            if arrival[i] <= i:
                break
            res += 1
        return res
        