//Java:

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        for(int x : arr){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        var set = new HashSet<>(map.values());
        return set.size() == map.size();
    }
}

//Python:

class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        freq = defaultdict(int)
        for x in arr:
            freq[x] += 1
        s = set(freq.values())
        return len(s) == len(freq)
