class Solution {
    public int hammingWeight(int n) {
        var res = 0;
        while(n != 0){
            res += (n & 1);
            n = n >>> 1;
        }
        return res;
    }
}
