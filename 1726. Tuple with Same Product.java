class Solution {
    public int tupleSameProduct(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int p = nums[i] * nums[j];
                map.put(p, map.getOrDefault(p, 0) + 1);
            }
        }
        int res = 0;
        for(int v : map.values()){
            if(v > 1){
                res += v * (v - 1)/2;
            }
        }
        return res * 8;
    }
}
