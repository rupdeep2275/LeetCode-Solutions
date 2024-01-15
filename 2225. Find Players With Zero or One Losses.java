//Java:

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        var lostMap = new TreeMap<Integer, Integer>();
        var players = new TreeSet<Integer>();
        for(var match : matches){
            players.add(match[0]);
            lostMap.put(match[1], lostMap.getOrDefault(match[1], 0) + 1);
        }
        var winners = new ArrayList<Integer>();
        var runnerUps = new ArrayList<Integer>();
        for(var player : lostMap.keySet()){
            if(lostMap.get(player) == 1) runnerUps.add(player);
        }
        for(var player : players){
            if(!lostMap.containsKey(player)) winners.add(player);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(winners); res.add(runnerUps);
        return res;
    }
}

//Python:

class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
      lost_map = defaultdict(int)
      players = set()
      for match in matches:
          lost_map[match[1]] += 1
          players.add(match[0])
      winners = [player for player in sorted(players) if player not in lost_map]
      runner_ups = []
      for player in lost_map:
          if lost_map[player] == 1:
              runner_ups.append(player)
      runner_ups.sort()
      return [winners, runner_ups]
      
