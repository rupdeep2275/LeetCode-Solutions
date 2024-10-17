class Solution {
    public int maximumSwap(int num) {
        var numArr = Integer.toString(num).toCharArray();
        var n = numArr.length;
        var maxRightIdx = new int[n];
        maxRightIdx[n - 1] = n - 1;
        for(var i=n-2; i>=0; i--){
            maxRightIdx[i] = (numArr[i] > numArr[maxRightIdx[i+1]]) ? i : maxRightIdx[i+1];
        }
        for(var i=0; i<n; i++){
            if(numArr[maxRightIdx[i]] > numArr[i]){
                var temp = numArr[i];
                numArr[i] = numArr[maxRightIdx[i]];
                numArr[maxRightIdx[i]] = temp;
                return Integer.parseInt(new String(numArr));
            }
        }
        return num;
    }
}

//Explanation: https://leetcode.com/problems/maximum-swap/solutions/5925562/two-pass-easy-solution/
