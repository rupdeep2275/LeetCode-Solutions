class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a : asteroids){
            if(a > 0) stack.push(a);
            else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) stack.pop();
                if(stack.isEmpty() || stack.peek() < 0) stack.push(a);
                else if(stack.peek() == -a) stack.pop();
            }
        }
        int[] res = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--) res[i] = stack.pop();
        return res;
    }
}
