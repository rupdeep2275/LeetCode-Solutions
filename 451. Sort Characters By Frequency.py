#Python:

class Solution:
    def frequencySort(self, s: str) -> str:
        freq_map = Counter(s)
        sorted_chars = sorted(freq_map, key = lambda x : (-freq_map[x], x))
        res = "".join([char * freq_map[char] for char in sorted_chars])
        return res


#Java:

class Solution {
    public String frequencySort(String s) {
        var map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        var list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        var sb = new StringBuilder();
        for(char c : list){
            int freq =  map.get(c);
            while(freq-->0) sb.append(c);
        }
        return sb.toString();
    }
}
