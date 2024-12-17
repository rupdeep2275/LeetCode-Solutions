class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        var map = new HashMap<Character, Integer>();
        var pq = new PriorityQueue<Character>((a, b) -> b - a);
        for(var i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(var c : map.keySet()) pq.add(c);
        var sb = new StringBuilder();
        while(!pq.isEmpty()){
            var c = pq.poll();
            var freq = map.get(c);
            var min = Math.min(freq, repeatLimit);
            while(min-->0) sb.append(c);
            freq -= repeatLimit;
            if(freq > 0 && !pq.isEmpty()){
                var c2 = pq.poll();
                sb.append(c2);
                if(map.get(c2) - 1 > 0){
                    pq.add(c2);
                    map.put(c2, map.getOrDefault(c2, 0) - 1);
                }
                pq.add(c);
                map.put(c, freq);
            }
        }
        return sb.toString();
    }
}
