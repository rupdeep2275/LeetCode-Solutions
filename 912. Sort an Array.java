class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    void mergeSort(int[] nums, int lo, int hi){
        if(lo == hi) return;
        int mid = (lo + hi) >> 1;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }
    void merge(int[] nums, int lo, int mid, int hi){
        int i = lo, j = mid + 1, x = 0;
        int[] temp = new int[hi - lo + 1];
        while(i <= mid && j <= hi){
            if(nums[i] < nums[j]) temp[x++] = nums[i++];
            else temp[x++] = nums[j++];
        }
        while(i <= mid) temp[x++] = nums[i++];
        while(j <= hi) temp[x++] = nums[j++];
        System.arraycopy(temp, 0, nums, lo, temp.length);
    }
}
