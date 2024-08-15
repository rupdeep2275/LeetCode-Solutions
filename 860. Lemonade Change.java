class Solution {
    public boolean lemonadeChange(int[] bills) {
        var wallet = new int[2]; // wallet[0] = number of $5 & wallet[1] = number of %10
        for(var b : bills){
            if(b == 5) wallet[0]++;
            else if(b == 10){
                wallet[0]--;
                wallet[1]++;
            }
            else if(b == 20){
                if(wallet[1] > 0){
                    wallet[1]--;
                    wallet[0]--;
                }
                else wallet[0] -= 3;
            }
            if(wallet[0] < 0 || wallet[1] < 0) return false;
        }
        return true;
    }
}
