class KthLargest {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        for(var n : nums) q.add(n);
        this.k = k;
    }
    
    public int add(int val) {
        q.add(val);
        while(q.size() > k) q.poll();
        return q.peek();
    }
}
