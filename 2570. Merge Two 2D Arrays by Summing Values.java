class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length, n = nums2.length, i = 0, j = 0;
        var res = new ArrayList<int[]>();
        while(i < m && j < n){
            if(nums1[i][0] < nums2[j][0]){
                res.add(nums1[i++]);
            }
            else if(nums2[j][0] < nums1[i][0]){
                res.add(nums2[j++]);
            }
            else res.add(new int[]{nums1[i][0], nums1[i++][1] + nums2[j++][1]});
        }
        while(i < m) res.add(nums1[i++]);
        while(j < n) res.add(nums2[j++]);
        return res.toArray(new int[res.size()][]);
    }
}
