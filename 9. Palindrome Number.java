class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int rev = 0, n = x;
        while(n > 0){
            int rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }
        return rev == x;
    }
}
