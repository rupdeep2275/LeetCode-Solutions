class LRUCache {
    Map<Integer, Node> map;
    int size;
    Node head, tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.size = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        deleteNode(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) deleteNode(map.get(key));
        else if(map.size() == size) deleteNode(tail.prev);
        addToHead(new Node(key, value));
    }

    private void addToHead(Node node){
        map.put(node.key, node);
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }

    private void deleteNode(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
class Node{
    int key, val;
    Node next, prev;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */



//OR

class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
