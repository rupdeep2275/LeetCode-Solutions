class Solution {
    public int countPairs(int[] deliciousness) {
        long mod = 1_000_000_007, res = 0;;
        Map<Integer, Integer> map = new HashMap<>();
        for(int d : deliciousness){
            for(int power=1; power<=1<<21; power<<=1){
                int target = power - d;
                res = (res + map.getOrDefault(target, 0)) % mod;
            }
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        return (int)res;
    }
}
