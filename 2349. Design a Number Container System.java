class NumberContainers {
    Map<Integer,PriorityQueue<Integer>> numberMap;;
    Map<Integer, Integer> indexMap;
    public NumberContainers() {
        numberMap = new HashMap<>();
        indexMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        indexMap.put(index, number);
        numberMap.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
    }
    
    public int find(int number) {
        if (!numberMap.containsKey(number)) {
            return -1; 
        }
        var pq = numberMap.get(number);
        while(!pq.isEmpty()){
            int index = pq.peek();
            if(indexMap.get(index) == number){
                return index;
            }
            pq.poll();
        }
        return -1;
    }
}
