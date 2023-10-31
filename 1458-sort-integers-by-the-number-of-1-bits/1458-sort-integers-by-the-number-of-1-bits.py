class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        def set_bits(n):
            count = 0
            while n:
                count += (n & 1)
                n = n >> 1
            return count
        res = [0] * len(arr)
        for i in range(len(arr)):
            res[i] = set_bits(arr[i]) * 10001 + arr[i]
        res.sort()
        for i in range(len(arr)):
            res[i] = res[i] % 10001
        return res

----------------------------------------------------------------------------

class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i] = setBits(arr[i])*10001 + arr[i];
        }
        Arrays.sort(res);
        for(int i=0; i<n; i++){
            res[i] = res[i] % 10001;
        }
        return res;
    }
    public int setBits(int n){
        int count = 0;
        while(n > 0){
            count += (n & 1);
            n = n >> 1;
        }
        return count;
    }
}
