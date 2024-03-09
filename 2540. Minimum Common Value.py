#Python:

class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        i, j = 0, 0
        while i < len(nums1) and j < len(nums2):
            if(nums1[i] == nums2[j]):
                return nums1[i]
            elif nums1[i] < nums2[j]:
                i += 1
            else:
                j += 1
        return -1

#Java:

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i=0, j=0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]) return nums1[i];
            else if(nums1[i] > nums2[j]) j++; 
            else i++; 
        }
        return -1;
    }
}
