class Solution {
    public int[] frequencySort(int[] nums) {
        var freq = new HashMap<Integer, Integer>();
        var res = new ArrayList<Integer>();
        for(var num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            res.add(num);
        }
        Collections.sort(res, (a, b) -> freq.get(a) == freq.get(b) ? b - a :freq.get(a) - freq.get(b));
        return res.stream().mapToInt(i->i).toArray();
    }
}
