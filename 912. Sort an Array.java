class Solution {
    public int[] sortArray(int[] nums) {
        var n = nums.length;
        mergeSort(nums, 0, n-1);
        return nums;
    }
    void mergeSort(int[] arr, int s, int e){
        if(s == e) return;
        int m = (s+e)/2;
        mergeSort(arr, s, m);
        mergeSort(arr, m+1, e);
        merge(arr, s, m, e);
    }
    void merge(int[] arr, int s, int m, int e){
        int i = s, j = m+1, x = 0;
        var temp = new int[e-s+1];
        while(i <= m && j <= e){
            if(arr[i] < arr[j]){
                temp[x++] = arr[i++];
            }
            else temp[x++] = arr[j++];
        }
        while(i <= m) temp[x++] = arr[i++];
        while(j <= e) temp[x++] = arr[j++];
        System.arraycopy(temp, 0, arr, s, temp.length);
    }
}
