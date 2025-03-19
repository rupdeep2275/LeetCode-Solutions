class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []
        for c in s:
            if stack and c == stack[-1][0]:
                stack[-1][1] += 1
            else:
                stack.append([c, 1])
            if stack[-1][1] == k:
                stack.pop()
        res = []
        for x in stack:
            res.append(x[0] * x[1])
        return ''.join(res)

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
