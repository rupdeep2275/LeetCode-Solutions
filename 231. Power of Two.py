#Python:

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n < 1:
            return False
        return n & (n - 1) == 0

      
#Java:

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        return (n & (n - 1)) == 0;
    }
}
