class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        var max = 0;
        for(var i=0; i<items.length; i++){
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }
        var res = new int[queries.length];
        for(var i=0; i<queries.length; i++){
            res[i] = binarySearch(items, queries[i]);
        }
        return res;
    }
    int binarySearch(int[][] items, int target){
        int lo = 0, hi = items.length - 1, idx = -1;
        while(lo <= hi){
            var mid = lo + (hi - lo)/2;
            if(items[mid][0] <= target){
                lo = mid + 1;
                idx = mid;
            }
            else hi = mid - 1;
        }
        if(idx == -1) return 0;
        return items[idx][1];
    }
}
