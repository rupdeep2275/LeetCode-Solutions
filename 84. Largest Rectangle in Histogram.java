class Solution {
    int n;
    Stack<Integer> stack;
    public int largestRectangleArea(int[] heights) {
        n = heights.length;
        int[] left = prevSmaller(heights), right = nextSmaller(heights);
        var res = 0;
        for(var i=0; i<n; i++){
            int p1 = left[i], p2 = right[i];
            res = Math.max((p2 - p1 - 1) * heights[i], res);
        }
        return res;
    }
    int[] prevSmaller(int[] arr){
        var res = new int[n];
        Arrays.fill(res, -1);
        stack = new Stack<>();
        for(var i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if(!stack.isEmpty()) res[i] = stack.peek();
            stack.push(i);
        }
        return res;
    }
    int[] nextSmaller(int[] arr){
        var res = new int[n];
        stack.clear();
        Arrays.fill(res, n);
        for(var i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if(!stack.isEmpty()) res[i] = stack.peek();
            stack.push(i);
        }
        return res;
    }
}
