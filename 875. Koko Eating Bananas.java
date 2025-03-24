class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int hi = 0, sum = 0;
        for(int pile : piles){
            hi = Math.max(pile, hi);
            sum += pile;
        }
        if(h == piles.length) return hi;
        int lo = (int) Math.ceil((double) sum / h);
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(canFinish(piles, mid, h)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    boolean canFinish(int[] piles, int k, int h){
        int time = 0;
        for(int pile : piles){
            time += Math.ceil((double)pile/k);
            if(time > h) return false;
        }
        return true;
    }
}
