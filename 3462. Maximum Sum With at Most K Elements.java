class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        List<Pair> list = new ArrayList<>();
        int i = 0;
        long res = 0;
        for(var row : grid){
            for(var num : row){
                list.add(new Pair(num, i));
            }
            i++;
        }
        Collections.sort(list, (a, b) -> b.val - a.val);
        for(var p : list){
            if(limits[p.row] > 0 && k > 0){
                res += p.val;
                limits[p.row]--;
                k--;
            }
            else if(k == 0) break;
        }
        return res;
    }
}
class Pair{
    int val, row;
    Pair(int val, int row){
        this.val = val;
        this.row = row;
    }
}
