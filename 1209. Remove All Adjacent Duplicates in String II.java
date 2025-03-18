class Solution {
    public String removeDuplicates(String s, int k) {
        var stack = new Stack<Pair>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && stack.peek().ch == ch){
                stack.peek().freq++;
            }
            else stack.push(new Pair(ch, 1));
            if(stack.peek().freq == k) stack.pop();
        }
        var sb = new StringBuilder();
        while(!stack.isEmpty()){
            while(stack.peek().freq-->0) sb.append(stack.peek().ch);
            stack.pop();
        }
        return sb.reverse().toString();
    }
}
class Pair{
    char ch;
    int freq;
    Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
