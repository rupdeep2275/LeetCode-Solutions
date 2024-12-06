class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        var set = new HashSet<Integer>();
        int sum = 0, count = 0;
        for(var num : banned) set.add(num);
        for(var i=1; i<=n; i++){
            if(!set.contains(i)){
                sum += i;
                if(sum > maxSum) break;
                count++;
            }
        }
        return count;
    }
}
