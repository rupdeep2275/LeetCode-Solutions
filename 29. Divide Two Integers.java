class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        long dd = Math.abs((long)dividend);
        long dv = Math.abs((long)divisor);

        boolean negative = (dividend < 0) ^ (divisor < 0);
        int res = 0;

        while(dv <= dd){
            long temp = dv, count = 1;
            while(temp << 1 <= dd){
                temp <<= 1;
                count <<= 1;
            }
            res += count;
            dd -= temp;
        }
        return negative ? -res : res;
    }
}
