class Solution {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        for(var i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty()){
                if((c == ')' && stack.peek() == '(') || 
                    (c == '}' && stack.peek() == '{') || 
                    (c == ']' && stack.peek() == '[')){
                        stack.pop();
                        continue;
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
