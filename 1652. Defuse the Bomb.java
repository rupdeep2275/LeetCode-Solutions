class Solution {
    public int[] decrypt(int[] code, int k) {
        var n = code.length;
        var res = new int[n];
        if(k == 0) return res;
        int start = 1, end = k, sum = 0;
        if(k < 0){
            start = n - Math.abs(k);
            end = n - 1;
        }
        for(var i=start; i<=end; i++) sum += code[i];
        for(var i=0; i< code.length; i++){
            res[i] = sum;
            sum -= code[start % n];
            start++;
            end++;
            sum += code[end % n];
        }
        return res;
    }
}
