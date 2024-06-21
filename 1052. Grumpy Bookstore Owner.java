//Java:

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int lo = 0, hi = minutes, total = 0, res = 0;
        for(var i=0; i<customers.length; i++){
            if(grumpy[i] == 0) total += customers[i];
        }
        for(var i=0; i<minutes; i++){
            if(grumpy[i] == 1) total += customers[i];
        }
        res = total;
        while(hi < customers.length){
            if(grumpy[lo] == 1) total -= customers[lo];
            if(grumpy[hi] == 1) total += customers[hi];
            res = Math.max(total, res);
            lo++; hi++;
        }
        return res;
    }
}
