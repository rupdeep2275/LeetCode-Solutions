#Python:

class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)

        @lru_cache(maxsize = None)
        def memoSolve(i, j):
            if i == m:
                return n - j
            elif j == n:
                return m - i
            temp = memoSolve(i+1, j+1)
            if word1[i] == word2[j]:
                return temp
            insert = 1 + memoSolve(i, j+1)
            delete = 1 + memoSolve(i+1, j)
            replace = 1 + temp
            return min(insert, delete, replace)
        
        return memoSolve(0, 0)


#Java

class Solution {
    String w1, w2;
    Integer[][] dp;
    int m, n;
    public int minDistance(String word1, String word2) {
        w1 = word1; w2 = word2;
        m = w1.length(); n = w2.length();
        dp = new Integer[m][n];
        return memoSolve(0, 0);
    }
    int memoSolve(int i, int j){
        if(i == m) return n - j;
        else if(j == n) return m - i;
        if(dp[i][j] != null) return dp[i][j];
        int res = 0, temp = memoSolve(i+1, j+1);
        if(w1.charAt(i) == w2.charAt(j)){
            res = temp;
        }
        else{
            int insert = 1 + memoSolve(i, j+1);
            int delete = 1 + memoSolve(i+1, j);
            int replace = 1 + temp;
            res = Math.min(insert, Math.min(delete, replace));
        }
        return dp[i][j] = res;
    }
}
