class Solution {
    public int maxDepth(String s) {
        var stack = new Stack<Character>();
        var res = 0;
        for(var i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(c);
            else if(c == ')') stack.pop();
            res = Math.max(res, stack.size());
        }
        return res;
    }
}
