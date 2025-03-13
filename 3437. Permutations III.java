class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int n;
    public int[][] permute(int n) {
        Set<Integer> used = new HashSet<>();
        this.n = n;
        backtrack(new ArrayList<>(), used);
        
        int[][] result = new int[res.size()][n];
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = res.get(i).get(j);
            }
        }
        return result;
    }
    
    void backtrack(List<Integer> temp, Set<Integer> used) {
        if(temp.size() == n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=1; i<=n; i++){
            if(used.contains(i)) continue;
            if(!temp.isEmpty()){
                int last = temp.get(temp.size()-1);
                if(last % 2 == i % 2) continue;
            }
            used.add(i);
            temp.add(i);
            backtrack(temp, used);
            used.remove(i);
            temp.remove(temp.size()-1);
        }
    }
}
