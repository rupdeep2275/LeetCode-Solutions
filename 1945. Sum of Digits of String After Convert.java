class Solution {
    public int getLucky(String s, int k) {
        var sb = new StringBuilder();
        for(var i=0; i<s.length(); i++){
            sb.append(Character.getNumericValue(s.charAt(i)));
        }
        var sum = 0;
        while(k-->0){
            sum = 0;
            for(var i=0; i<sb.length(); i++){
                sum += Character.getNumericValue(sb.charAt(i));
            }
            sb = new StringBuilder(String.valueOf(sum));
        }
        return sum;
    }
}
