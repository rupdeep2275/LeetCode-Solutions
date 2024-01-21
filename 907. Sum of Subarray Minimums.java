//Java:

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int[] left = prevSmaller(arr);
        int[] right = nextSmaller(arr);
        long res = 0;
        for(int i=0; i<arr.length; i++){
            int s = i - left[i];
            int e = right[i] - i;
            long count = (s * e) % mod;
            res += (count * arr[i]) % mod;
            res %= mod;
        }
        return (int)res;
    }
    private int[] prevSmaller(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        var stack = new Stack<Integer>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
    private int[] nextSmaller(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, n);
        var stack = new Stack<Integer>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}

//Python: 

class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        mod = 1_000_000_007
        left = self.prev_smaller(arr)
        right = self.next_smaller(arr)
        res = 0
        for i in range(len(arr)):
            s = i - left[i]
            e = right[i] - i
            count = (s * e) % mod
            res += (count * arr[i]) % mod
            res %= mod
        return res
    def prev_smaller(self, arr):
        n = len(arr)
        res = [-1] * n
        stack = []
        for i in range(n):
            while stack and arr[stack[-1]] > arr[i]:
                stack.pop()
            if stack:
                res[i] = stack[-1]
            stack.append(i)
        return res
    def next_smaller(self, arr):
        n = len(arr)
        res = [n] * n
        stack = []
        for i in range(n - 1, -1, -1):
            while stack and arr[stack[-1]] >= arr[i]:
                stack.pop()
            if stack:
                res[i] = stack[-1]
            stack.append(i)
        return res
