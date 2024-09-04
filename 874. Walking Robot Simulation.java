class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        var directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        var set = new HashSet<String>();
        for(var ob : obstacles){
            set.add(ob[0] + " " + ob[1]);
        }
        int x = 0, y = 0, res = 0, direction = 0;
        for(var com : commands){
            if(com == -2) direction = (direction + 3) % 4;
            else if(com == -1) direction = (direction + 1) % 4;
            else{
                var step = 0;
                while(step < com && !set.contains((x + directions[direction][0]) + " " + (y + directions[direction][1]))){
                    x += directions[direction][0];
                    y += directions[direction][1];
                    step++;
                }
            }
            res = Math.max(res, x * x + y * y);
        }
        return res;
    }
}
