class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int i = 0, j = 0;
        int[] res = new int[nums.length];
        for(int num : nums){
            if(num < pivot){
                res[i++] = num;
                j++;
            }
            else if(num == pivot) j++;
        }
        while(i < j) res[i++] = pivot;
        for(int num : nums){
            if(num > pivot) res[j++] = num;
        }
        return res;
    }
}
