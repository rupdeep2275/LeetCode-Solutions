class Solution {
    public String longestDiverseString(int a, int b, int c) {
        var pq = new PriorityQueue<Pair>((x, y) -> y.count - x.count);
        if(a > 0) pq.add(new Pair(a,'a'));
        if(b > 0) pq.add(new Pair(b,'b'));
        if(c > 0) pq.add(new Pair(c,'c'));
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            var p = pq.poll();
            if(sb.length() >= 2 && sb.charAt(sb.length()-1) == p.ch && sb.charAt(sb.length()-2) == p.ch){
                if(pq.isEmpty()) break;
                var q = pq.poll();
                sb.append(q.ch);
                q.count--;
                if(q.count > 0) pq.add(q);
            }
            else{
                p.count--;
                sb.append(p.ch);
            }
            if(p.count>0) pq.add(p); 
        }
        return sb.toString();
    }
}
class Pair {
    int count;
    char ch;
    Pair(int count, char ch) {
        this.count = count;
        this.ch = ch;
    }
}

//Explanation: https://leetcode.com/problems/longest-happy-string/solutions/5920935/intuitive-heap-solution/
