#Python:

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq_map = defaultdict(int)
        for char in s:
            freq_map[char] += 1
        res = []
        for char in order:
            res.append(char * freq_map[char])
            del freq_map[char]
        for char in freq_map:
            res.append(char * freq_map[char])
        return "".join(res)

#Java:

class Solution {
    public String customSortString(String order, String s) {
        var map = new HashMap<Character, Integer>();
        for(var i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(var i=0; i<order.length(); i++){
            if(map.containsKey(order.charAt(i))){
                for(var j=0; j<map.get(order.charAt(i)); j++) sb.append(order.charAt(i));
                map.remove(order.charAt(i));
            }
        }
        for(var c : map.keySet()){
            for(var i=0; i<map.get(c); i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
