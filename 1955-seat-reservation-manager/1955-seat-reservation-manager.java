class SeatManager {
    private int[] arr;
    private int len;
    private int min;
    public SeatManager(int n) {
        arr = new int[n+1];
        len = n+1;
        min = 1;
    }
    
    public int reserve() {
        arr[min] = 1;
        int i = min;
        while(min < len){
            if(arr[min] == 0){
                break;
            }
            min++;
        }
        return i;
    }
    
    public void unreserve(int seatNumber) {
        arr[seatNumber] = 0;
        min = Math.min(min, seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */