class Solution {
    int[] c;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        var comb = new LinkedList<Integer>();
        this.c = candidates;
        backtrack(target, comb, 0);
        return res;
    }
    void backtrack(int remain, LinkedList<Integer> comb, int index){
        if(remain == 0){
            res.add(new ArrayList<Integer>(comb));
        }
        else if(remain < 0) return;
        for(int i=index; i<c.length; i++){
            comb.add(c[i]);
            backtrack(remain-c[i], comb, i);
            comb.removeLast();
        }
    }
}
