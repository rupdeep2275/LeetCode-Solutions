class Solution {
    public boolean canChange(String start, String target) {
        ArrayList<Pair> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        for(var i=0; i<start.length(); i++){
            if(start.charAt(i) == 'R' || start.charAt(i) == 'L'){
                l1.add(new Pair(start.charAt(i), i));
            }
            if(target.charAt(i) == 'R' || target.charAt(i) == 'L'){
                l2.add(new Pair(target.charAt(i), i));
            }
        }
        if(l1.size() != l2.size()) return false;
        for(var i=0; i<l1.size(); i++){
            Pair p1 = l1.get(i), p2 = l2.get(i);
            if(p1.c != p2.c) return false;
            if(p1.c == 'R' && p2.idx < p1.idx) return false;
            else if(p1.c == 'L' && p2.idx > p1.idx) return false;
        }
        return true;
    }
}
class Pair{
    char c;
    int idx;
    Pair(char c, int idx){
        this.c = c;
        this.idx = idx;
    }
}
