class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length(), countOnes = 0, i = 0;
        for(var j=0; j<n; j++){
            if(s.charAt(j) == '1') countOnes++;
        }
        StringBuilder sb = new StringBuilder();
        while(i < countOnes - 1){
            sb.append('1');
            i++;
        }
        while(i < n - 1){
            sb.append('0');
            i++;
        }
        sb.append('1');
        return sb.toString();
    }
}
