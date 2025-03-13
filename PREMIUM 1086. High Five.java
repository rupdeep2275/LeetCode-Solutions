class Solution {
    public int[][] highFive(int[][] items) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int i = 0;
        while(i < items.length){
            int avg = 0;
            for(int j=i; j<i+5; j++) avg += items[j][1];
            i += 5;
            res.add(new int[]{items[i-1][0], avg/5});
            while(i < items.length && items[i][0] == items[i-1][0]) i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
