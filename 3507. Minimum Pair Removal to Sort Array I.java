class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            arr.add(nums[i]);
        }
        int count = 0;
        while(arr.size() > 1){
            boolean isAscending = true;
            int minSum = Integer.MAX_VALUE, minSumIndex = -1;
            for(int i=1; i<arr.size(); i++){
                if(arr.get(i) < arr.get(i-1)){
                    isAscending = false;
                }
                if(arr.get(i) + arr.get(i-1) < minSum){
                    minSum = arr.get(i) + arr.get(i-1);
                    minSumIndex = i-1;
                }
            }
            if(isAscending){
                break;
            }
            arr.remove(minSumIndex);
            arr.remove(minSumIndex);
            arr.add(minSumIndex, minSum);
            count++;
        }
        return count;
    }
}
