class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int vMax = 0, cMax = 0;
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            freq[index]++;
            if(isVowel(s.charAt(i))){
                vMax = Math.max(vMax, freq[index]);
            }
            else cMax = Math.max(cMax, freq[index]);
        }
        return vMax + cMax;
    }
    boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
