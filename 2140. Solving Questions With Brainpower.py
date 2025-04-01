class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)
        
        @lru_cache(maxsize = None)
        def memoSolve(i):
            if i >= n:
                return 0
            res = memoSolve(i+1)
            points, skip = questions[i]
            res = max(res, points + memoSolve(i + skip + 1))
            return res
        
        return memoSolve(0)


class Solution {
    Long[] dp;
    public long mostPoints(int[][] questions) {
        dp = new Long[questions.length];
        return memoSolve(0, questions);
    }
    long memoSolve(int i, int[][] questions){
        if(i >= questions.length) return 0;
        if(dp[i] != null) return dp[i];
        int points = questions[i][0], skip = questions[i][1];
        long res = memoSolve(i + 1, questions);
        res = Math.max(res, points + memoSolve(i + skip + 1, questions));
        return dp[i] = res;
    }
}
