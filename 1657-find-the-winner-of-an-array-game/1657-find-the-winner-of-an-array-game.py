class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        q = deque(arr)
        max_val = max(arr)
        curr = q.popleft()
        streak = 0
        while True:
            opp = q.popleft()
            if curr > opp:
                q.append(opp)
                streak += 1
            else:
                q.append(curr)
                curr = opp
                streak = 1

            if streak == k or curr == max_val:
                return curr