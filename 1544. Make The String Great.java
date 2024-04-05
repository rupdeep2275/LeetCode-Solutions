class Solution {
    public String makeGood(String s) {
        var stack = new Stack<Character>();
        for(var i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && c == toggle(stack.peek())){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
    public char toggle(char c){
        if(Character.isUpperCase(c)){
            return Character.toLowerCase(c);
        }
        return Character.toUpperCase(c);
    }
}
