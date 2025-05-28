class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = 0;
        Map<Integer, List<Integer>> diaMap = new HashMap<>();
        for(int i=nums.size()-1; i>=0; i--){
            for(int j=0; j<nums.get(i).size(); j++){
                int dia = i + j;
                diaMap.computeIfAbsent(dia, k -> new ArrayList()).add(nums.get(i).get(j));
                n++;
            }
        }
        int i = 0, curr = 0;
        int[] res = new int[n];
        while(diaMap.containsKey(curr)){
            for(int num : diaMap.get(curr)) res[i++] = num;
            curr++;
        }
        return res;
    }
}
