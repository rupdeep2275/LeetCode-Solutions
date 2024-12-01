#Python:

class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        s = set()
        for num in arr:
            if num * 2 in s or (num % 2 == 0 and num // 2 in s):
                return True
            s.add(num)
        return False

#Java:

class Solution {
    public boolean checkIfExist(int[] arr) {
        var set = new HashSet<Integer>();
        for(var num : arr){
            if(set.contains(2 * num)) return true;
            if(num % 2 == 0 && set.contains(num/2)) return true;
            set.add(num);
        }
        return false;
    }
}
