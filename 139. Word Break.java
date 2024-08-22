class Solution {
    Set<String> set;
    String s;
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        dp = new Boolean[s.length()];
        set = new HashSet<>(wordDict);
        return memoSolve(0);
    }
    boolean memoSolve(int index){
        if(index == s.length()) return true;
        if(dp[index] != null) return dp[index];
        for(var i=index+1; i<=s.length(); i++){
            if(set.contains(s.substring(index, i)) && memoSolve(i)){
                return dp[index] = true;
            }
        }
        return dp[index] = false;
    }
}
