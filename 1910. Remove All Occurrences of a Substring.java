class Solution {
    public String removeOccurrences(String s, String part) {
        var stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            stack.push(s.charAt(i));
            if(stack.size() >= part.length() && match(stack, part)){
                for(int j=0; j<part.length(); j++) stack.pop();
            }
        }
        var sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
    boolean match(Stack<Character> stack, String part){
        var temp = new Stack<Character>();
        temp.addAll(stack);
        for(int i=part.length()-1; i>=0; i--){
            if(part.charAt(i) == temp.peek()) temp.pop();
            else return false;
        }
        return true;
    }
}
