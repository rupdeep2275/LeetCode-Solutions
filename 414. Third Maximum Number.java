class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;
        for(int num : nums){
            if(num > max){
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            }
            else if(num == max) continue;
            else if(num > secondMax){
                thirdMax = secondMax;
                secondMax = num;
            }
            else if(num == secondMax) continue;
            else if(num > thirdMax) thirdMax = num;
        }
        return thirdMax != Long.MIN_VALUE ? (int)thirdMax : (int)max;
    }
}
