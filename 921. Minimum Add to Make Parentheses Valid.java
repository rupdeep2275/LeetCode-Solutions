class Solution {
    public int minAddToMakeValid(String s) {
        var stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for(var i=1; i<s.length(); i++){
            var c = s.charAt(i);
            if(!stack.isEmpty() && c == ')' && stack.peek() == '(') stack.pop();
            else stack.push(c);
        }
        return stack.size();
    }
}
