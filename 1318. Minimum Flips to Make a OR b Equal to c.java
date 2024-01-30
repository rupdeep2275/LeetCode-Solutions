class Solution {
    public int minFlips(int a, int b, int c) {
        var res = 0;
        for(int i=0; i<32; i++){
            var ai = false;
            var bi = false;
            var ci = false;
            if((a & (1 << i)) > 0) ai = true;
            if((b & (1 << i)) > 0) bi = true;
            if((c & (1 << i)) > 0) ci = true;
            if(ci){
                if(!ai && !bi) res ++;
            }
            else{
                if(ai && bi) res += 2;
                else if(ai || bi) res++;
            }
        }
        return res;
    }
}
