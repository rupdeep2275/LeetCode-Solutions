#Python:

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        res = [0] * n
        stack = []
        for i in range(n - 1, -1, -1):
            while stack and temperatures[stack[-1]] <= temperatures[i]:
                stack.pop()
            if stack:
                res[i] = stack[-1] - i
            stack.append(i)
        return res


#Java:

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var n = temperatures.length;
        var res = new int[n];
        CustomStack stack = new CustomStack();
        for(var i=n-1; i>=0; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();
            if(!stack.isEmpty()) res[i] = stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
class CustomStack{
    List<Integer> stack;
    CustomStack(){
        stack = new LinkedList<>();
    }
    void push(int val){
        stack.add(val);
    }
    void pop(){
        stack.removeLast();
    }
    int peek(){
        return stack.getLast();
    }
    boolean isEmpty(){
        return stack.isEmpty();
    }
}
