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
        var stack = new Stack<int[]>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && stack.peek()[0] == ch){
                stack.peek()[1]++;
            }
            else stack.push(new int[]{ch, 1});
            if(stack.peek()[1] == k) stack.pop();
        }
        var sb = new StringBuilder();
        while(!stack.isEmpty()){
            while(stack.peek()[1]-->0) sb.append((char)stack.peek()[0]);
            stack.pop();
        }
        return sb.reverse().toString();
    }
}
