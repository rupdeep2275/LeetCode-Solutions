class Solution {
    public int countHomogenous(String s) {
        int res = 0;
        int mod = 1_000_000_007;
        int streak = 0;
        for(int i=0; i<s.length(); i++){
            if(i==0 || s.charAt(i) == s.charAt(i-1)){
                streak++;
            }
            else{
                streak = 1;
            }
            res = (res + streak) % mod;
        }
        return res;
    }
}
