class Solution {
    public String reorganizeString(String s) {
        var map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        var pq = new PriorityQueue<Pair>((a, b) -> b.freq - a.freq);
        for(var entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        var sb = new StringBuilder();
        while(pq.size() > 1){
            var first = pq.poll();
            var second = pq.poll();
            sb.append(first.ch);
            sb.append(second.ch);
            if(--first.freq > 0) pq.add(first);
            if(--second.freq > 0) pq.add(second);
        }
        while(!pq.isEmpty()){
            var last = pq.poll();
            if(last.freq > 1) return "";
            sb.append(last.ch);
        }
        return sb.toString();
    }
}
class Pair{
    char ch;
    int freq;
    Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
