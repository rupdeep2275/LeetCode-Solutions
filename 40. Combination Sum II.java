class Solution {
    protected void backtrack(
            int remain,
            LinkedList<Integer> comb,
            int index, int[] candidates,
            List<List<Integer>> ans) {

        if (remain == 0) {
            // make a deep copy of the current currination
            ans.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        for (int i = index; i < candidates.length; ++i) {
            // add the number into the currination
            if(i != index && candidates[i] == candidates[i-1]){
                continue;
            }
            comb.add(candidates[i]);
            backtrack(remain - candidates[i], comb, i + 1, candidates, ans);
            // backtrack, remove the number from the currination
            comb.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        backtrack(target, comb, 0, candidates, ans);
        return ans;
    }
}
