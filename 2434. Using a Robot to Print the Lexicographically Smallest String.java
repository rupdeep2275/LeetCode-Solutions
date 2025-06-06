class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        int[] minSuffix = new int[n];
        minSuffix[n-1] = s.charAt(n-1);
        for(int i=n-2; i>=0; i--) minSuffix[i] = Math.min(s.charAt(i), minSuffix[i+1]);
        Stack<Character> stack = new Stack();
        StringBuilder res = new StringBuilder();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            stack.push(c);
            while(!stack.isEmpty() && (i==n-1 || stack.peek() <= minSuffix[i+1])){
                res.append(stack.pop());
            }
        }
        while(!stack.isEmpty()) res.append(stack.pop());
        return res.toString();
    }
}
