#Python:

class Solution:
    def pivotInteger(self, n: int) -> int:
        l_sum, r_sum = 0, 0
        for i in range(1, n+1):
            r_sum += i
        for i in range(1, n+1):
            l_sum += i
            if l_sum == r_sum:
                return i
            r_sum -= i
        return -1

#Java:

class Solution {
    public int pivotInteger(int n) {
        int lSum = 0, rSum = 0;
        for(var i=1; i<=n; i++){
            rSum += i;
        }
        for(var i=1; i<=n; i++){
            lSum += i;
            if(lSum == rSum) return i;
            rSum -= i;
        }
        return -1;
    }
}
