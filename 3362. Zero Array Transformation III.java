class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] diffArr = new int[nums.length + 1];
        int operations = 0;
        for(int i=0, j=0; i<nums.length; i++){
            operations += diffArr[i];
            while(j < queries.length && queries[j][0] == i){
                pq.add(queries[j][1]);
                j++;
            }
            while(operations < nums[i] && !pq.isEmpty() && pq.peek() >= i){
                operations += 1;
                diffArr[pq.poll() + 1] -= 1;
            }
            if(operations < nums[i]) return -1;
        }
        return pq.size();
    }
}
