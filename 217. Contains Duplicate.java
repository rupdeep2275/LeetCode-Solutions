class Solution {
    public boolean containsDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for(var n : nums){
            if(set.contains(n)) return true;
            else set.add(n);
        }
        return false;
    }
}
