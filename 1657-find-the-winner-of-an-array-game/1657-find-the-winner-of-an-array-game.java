class Solution {
    public int getWinner(int[] arr, int k) {
        Queue<Integer> q = new LinkedList<>();
        int max = 0;
        for(int num : arr){
            max = Math.max(num, max);
            q.add(num);
        }
        int curr = q.poll();
        int streak = 0;
        while(true){
            int opp = q.poll();

            if(curr > opp){
                q.add(opp);
                streak++;
            }
            else{
                q.add(curr);
                curr = opp;
                streak = 1;
            }

            if(streak == k || curr == max){
                return curr;
            }
        }
    }
}