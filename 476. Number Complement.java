class Solution {
    public int findComplement(int num) {
        var n = 0;
        for(var i=1; n<num; i=i*2){
            n += i;
        }
        return num^n;
    }
}
