class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b [1] : b[0] - a[0]);
        for(var p : people) res.add(p[1], p);
        return res.toArray(new int[people.length][2]);
    }
}
