class Solution {
    public int[] nextGreaterElements(int[] nums) {
        var n = nums.length;
        var res = new int[n];
        Arrays.fill(res, -1);
        var stack = new Stack<Integer>();
        for(var i=2*n-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%n]) stack.pop();
            if(!stack.isEmpty()) res[i%n] = stack.peek();
            stack.add(nums[i%n]);
        }
        return res;
    }
}
