class Solution {
    int n;
    public int[] maxSlidingWindow(int[] nums, int k) {
        n = nums.length;
        var nge = nextGreaterElements(nums);
        var res = new ArrayList<Integer>();
        var j = 0;
        for(var i=0; i<=n-k; i++){
            if(j < i) j = i;
            while(nge[j]<i+k){
                j = nge[j];
            }
            res.add(nums[j]);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    public int[] nextGreaterElements(int[] nums) {
        var res = new int[n];
        var stack = new Stack<Integer>();
        for(var i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) stack.pop();
            if(!stack.isEmpty()) res[i] = stack.peek();
            else res[i] = n;
            stack.add(i);
        }
        return res;
    }
}
