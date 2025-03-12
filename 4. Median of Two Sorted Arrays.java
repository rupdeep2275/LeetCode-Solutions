class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int n = n1 + n2, lo = 0, hi = n1, left = (n + 1) >> 1;
        while(lo <=  hi){
            int mid1 = (lo + hi) >> 1, mid2 = left - mid1;
            int l1 = mid1 - 1 >= 0 ? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2 = mid2 - 1 >= 0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? nums2[mid2] : Integer.MAX_VALUE;
            if(l1 <= r2 && l2 <= r1){
                if(n % 2 != 0) return Math.max(l1, l2);
                return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
            }
            else if(l1 > r2){
                hi = mid1 - 1;
            }
            else lo = mid1 + 1;
        }
        return 0.0;
    }
}
