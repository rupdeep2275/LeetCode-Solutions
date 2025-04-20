class Solution {
    String s1, s2, s3;
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        this.s1 = s1; this.s2 = s2; this.s3 = s3;
        dp = new Boolean[s1.length()][s2.length()];
        return memoSolve(0, 0, 0);
    }
    boolean memoSolve(int i, int j, int k){
        if(i == s1.length()) return s2.substring(j).equals(s3.substring(k));
        else if(j == s2.length()) return s1.substring(i).equals(s3.substring(k));
        if(dp[i][j] != null) return dp[i][j];
        boolean res = false;
        if(s1.charAt(i) == s3.charAt(k)) res = res || memoSolve(i+1, j, k+1);
        if(s2.charAt(j) == s3.charAt(k)) res = res || memoSolve(i, j+1, k+1);
        return dp[i][j] = res;
    }
}
