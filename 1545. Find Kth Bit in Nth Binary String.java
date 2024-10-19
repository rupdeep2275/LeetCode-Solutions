class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0';
        var len = 1 << n; //length of Sn ~ 2^n
        if(k < len/2) return findKthBit(n-1, k); //if k in first half
        if(k == len/2) return '1'; //middle char is always 1
        return findKthBit(n-1, len-k) == '1' ? '0' : '1'; //find corresponding bit in first-half & invert
    }
}
