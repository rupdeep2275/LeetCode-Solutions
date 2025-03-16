class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    int mergeSort(int[] nums, int lo, int hi){
        if(lo == hi) return 0;
        int mid = (lo + hi) >> 1, count = 0;
        count += mergeSort(nums, lo, mid) + mergeSort(nums, mid + 1, hi);
        return count += merge(nums, lo, mid, hi);
    }
    int merge(int[] nums, int lo, int mid, int hi){
        int i = lo, j = mid + 1, x = 0, count = 0;
        while(i <= mid && j <= hi){
            if((long) nums[i] >  2 * (long) nums[j]){
                count += mid - i + 1;
                j++;
            }
            else i++;
        }
        i = lo;
        j = mid + 1;
        int[] temp = new int[hi - lo + 1];
        while(i <= mid && j <= hi){
            if(nums[i] < nums[j]) temp[x++] = nums[i++];
            else temp[x++] = nums[j++];
        }
        while(i <= mid) temp[x++] = nums[i++];
        while(j <= hi) temp[x++] = nums[j++];
        System.arraycopy(temp, 0, nums, lo, temp.length);
        return count;
    }
}
