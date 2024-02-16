// Java:

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        var map = new HashMap<Integer, Integer>();
        for(var n : arr){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> a.getValue() - b.getValue());
        for(var entry : list){
            if(entry.getValue() <= k){
                k -= entry.getValue();
                map.remove(entry.getKey());
            }
            else{
                break;
            }
        }
        return map.size();
    }
}

// Python:

class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        freq = defaultdict(int)
        for n in arr:
            freq[n] += 1
        sorted_freq = sorted(freq.items(), key = lambda x : x[1])
        for key, val in sorted_freq:
            if val <= k:
                k -= val
                del freq[key]
            else:
                break
        return len(freq)
