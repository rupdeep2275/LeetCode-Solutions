class Solution {
    public int minLength(String s) {
        var stack = new Stack<Character>();
        stack.add(s.charAt(0));
        for(var i=1; i<s.length(); i++){
            if(!stack.isEmpty()){
                if(s.charAt(i) == 'B' && stack.peek() == 'A'){
                    stack.pop();
                    continue;
                }
                else if(s.charAt(i) == 'D' && stack.peek() == 'C'){
                    stack.pop();
                    continue;
                }
            }
            stack.add(s.charAt(i));
        }
        return stack.size();
    }
}
