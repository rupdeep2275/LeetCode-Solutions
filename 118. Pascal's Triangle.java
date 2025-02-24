class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        if(numRows >= 2) res.add(List.of(1, 1));
        for(int i=2; i<numRows; i++){
            var prev = res.get(i-1);
            var curr = new ArrayList<Integer>();
            curr.add(1);
            for(int j=1; j<prev.size(); j++){
                curr.add(prev.get(j-1)+prev.get(j));
            }
            curr.add(1);
            res.add(curr);
        }
        return res;
    }
}
