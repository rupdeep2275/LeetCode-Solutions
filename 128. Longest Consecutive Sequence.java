class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for(var n : nums) set.add(n);
        var res = 0;
        for(var n : set){
            if(!set.contains(n - 1)){
                int i = 1;
                while(set.contains(n+i)) i++;
                res = Math.max(res, i);
            }
        }
        return res;
    }
}
