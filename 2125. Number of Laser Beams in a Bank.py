#Python:

class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        res, prev = 0, 0
        for str in bank:
            curr = str.count('1')
            if curr > 0:
                res += curr * prev
                prev = curr
        return res

#Java:

class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int prevCount = 0;
        for(String str : bank){
            int currCount = countOnes(str);
            if(currCount > 0){
                res += prevCount * currCount;
                prevCount = currCount;
            }
        }
        return res;
    }
    public int countOnes(String str){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1') count++;
        }
        return count;
    }
}
