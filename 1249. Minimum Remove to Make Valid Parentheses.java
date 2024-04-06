class Solution {
    public String minRemoveToMakeValid(String s) {
        var stack = new Stack<Pair>();
        for(var i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && c == ')' && stack.peek().x == '(') stack.pop();
            else if(c == ')' || c == '('){
                stack.push(new Pair(c, i));
            }
        }
        var set = new HashSet<Integer>();
        while(!stack.isEmpty()) set.add(stack.pop().y);
        StringBuilder sb = new StringBuilder();
        for(var i=0; i<s.length(); i++){
            if(set.contains(i)) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
class Pair{
    char x;
    int y;
    Pair(char x, int y){
        this.x = x;
        this.y = y;
    }
}
