public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        var res = 0;
        for(var i=0; i<32; i++){
            var reversedBit = (n & 1) << (31 - i);
            res = res | reversedBit;
            n = n >> 1;
        }
        return res;
    }
}
