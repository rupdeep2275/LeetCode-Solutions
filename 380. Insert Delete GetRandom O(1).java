//Java:

class RandomizedSet {
    private Map<Integer,Integer> map;
    private List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() -1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        Collections.swap(list, index, list.size() - 1);
        int swappedInteger = list.get(index);
        map.put(swappedInteger, index);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

//Python:

class RandomizedSet:

    def __init__(self):
        self.map = {}
        self.list = []

    def insert(self, val: int) -> bool:
        if val in self.map:
            return False
        self.map[val] = len(self.list)
        self.list.append(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self.map:
            return False
        idx = self.map[val]
        last_element = self.list[-1]
        self.list[idx] = last_element
        self.map[last_element] = idx
        self.list.pop()
        del self.map[val]
        return True 

    def getRandom(self) -> int:
        return random.choice(self.list)
   
