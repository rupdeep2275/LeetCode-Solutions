//Java:

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        var set2 = new HashSet<Integer>();
        for(var n : nums1) set1.add(n);
        for(var n : nums2){
            if(set1.contains(n)){
                set2.add(n);
            }
        }
        // or
        // for(var n : nums2) set2.add(i);
        // set2.retainAll(set1);
        int[] res = new int[set2.size()];
        var i = 0;
        for(var n : set2){
            res[i++] = n;
        }
        return res;
    }
}

//Python:

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        set1, set2 = set(), set()
        for n in nums1:
            set1.add(n)
        for n in nums2:
            if n in set1:
                set2.add(n)
        res = [0] * len(set2)
        i = 0
        for n in set2:
            res[i] = n
            i += 1
        return res
