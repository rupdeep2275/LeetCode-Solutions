class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length, res = 0;
        for(int i=0; i<n; i++){
            int num = colors[i], j = 1;
            while(j < 3){
                if(colors[(i+j)%n] != Math.abs(num - 1)) break;
                num = Math.abs(num - 1);
                j++;
            }
            if(j == 3) res++;
        }
        return res;
    }
}
