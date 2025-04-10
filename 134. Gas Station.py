class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
      total_sum = 0
      curr_sum = 0
      res = 0
      for i in range(len(gas)):
        total_sum += gas[i] - cost[i]
        curr_sum += gas[i] - cost[i]
        if curr_sum < 0:
          res = i + 1
          curr_sum = 0
      return res if total_sum >= 0 else -1

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currDiff = 0, totalDiff = 0, res = 0;
        for(int i=0; i<gas.length; i++){
            totalDiff += gas[i] - cost[i];
            currDiff += gas[i] - cost[i];
            if(currDiff < 0){
                res = i + 1;
                currDiff = 0;
            }
        }
        return totalDiff >= 0 ? res : -1;
    }
}
