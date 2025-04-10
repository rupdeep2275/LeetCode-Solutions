class LFUCache {
    private HashMap<Integer, Integer> keyValMap, keyFreqMap;
    private HashMap<Integer, LinkedHashSet<Integer>> freqKeyMap;
    private int capacity, min;
    public LFUCache(int capacity) {
        keyValMap = new HashMap<>();
        keyFreqMap = new HashMap<>();
        freqKeyMap = new HashMap<>();
        this.capacity = capacity;
        min = 1;
    }
    
    public int get(int key) {
        if(!keyValMap.containsKey(key)) return -1;
        int freq = keyFreqMap.get(key);
        keyFreqMap.put(key, freq + 1);
        freqKeyMap.get(freq).remove(key);
        if(freq == min && freqKeyMap.get(freq).size() == 0) min++;
        freqKeyMap.computeIfAbsent(freq+1, k -> new LinkedHashSet<>()).add(key);
        return keyValMap.get(key);
    }
    
    public void put(int key, int value) {
        if(keyValMap.containsKey(key)){
            keyValMap.put(key, value);
            get(key);
            return;
        }
        if(keyValMap.size() == capacity){
            int evict = freqKeyMap.get(min).iterator().next();
            freqKeyMap.get(min).remove(evict);
            keyValMap.remove(evict);
            keyFreqMap.remove(evict);
        }
        keyValMap.put(key, value);
        keyFreqMap.put(key, 1);
        min = 1;
        freqKeyMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
