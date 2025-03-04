class Solution {
    public boolean checkPowersOfThree(int n) {
        var res = new ArrayList<Integer>();
        int x = 1;
        res.add(x);
        while(true){
            x *= 3;
            if(x > n) break;
            res.add(x);
        }
        for(int i=res.size()-1; i>=0; i--){
            if(res.get(i) <= n) n -= res.get(i);
            if(n == 0) return true;
        }
        return false;
    }
}
