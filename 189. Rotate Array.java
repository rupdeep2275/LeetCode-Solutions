class Solution {
    public void rotate(int[] nums, int k) {
        var n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    void reverse(int[] nums, int i, int j){
        while(i < j){
            var temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
