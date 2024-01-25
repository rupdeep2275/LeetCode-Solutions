class Solution {
    String text1, text2;
    Integer[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        this.memo = new Integer[text1.length()][text2.length()];
        this.text1 = text1;
        this.text2 = text2;
        return memoSolve(0, 0);
    }
    private int memoSolve(int i, int j){
        if(i == text1.length() || j == text2.length()) return 0;
        if(memo[i][j] != null) return memo[i][j];
        int res = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            res = 1 + memoSolve(i+1, j+1);
        }
        else{
            res = Math.max(memoSolve(i, j+1), memoSolve(i+1, j));
        }
        return memo[i][j] = res;
    }
}
