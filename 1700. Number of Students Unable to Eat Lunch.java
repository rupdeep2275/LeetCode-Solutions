class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        var stack = new Stack<Integer>();
        for(var s : students){
            q.add(s);
        }
        for(int i=sandwiches.length-1; i>=0; i--){
            stack.add(sandwiches[i]);
        }
        int size = q.size();
        while(size > 0){
            if(q.peek() == stack.peek()){
                q.poll();
                stack.pop();
                size = q.size();
            }
            else{
                q.add(q.poll());
                size--;
            }
        }
        return q.size();
    }
}
