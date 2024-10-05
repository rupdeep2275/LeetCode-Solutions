class Solution {
    public int findTheWinner(int n, int k) {
        return helper(n, k) + 1;
    }
    int helper(int n, int k){
        if(n==1) return 0;
        var x = helper(n-1, k);
        return (x+k)%n;
    }
}
