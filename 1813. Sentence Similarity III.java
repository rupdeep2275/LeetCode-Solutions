class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        String[] s1Words = s1.split(" "), s2Words = s2.split(" ");
        int start = 0, s1Len = s1Words.length, s2Len = s2Words.length;
        int s1End = s1Len - 1, s2End = s2Len -1;
        if(s1Len > s2Len) return areSentencesSimilar(s2, s1);
        while(start < s1Len && s1Words[start].equals(s2Words[start])){
            start++;
        }
        while(s1End >= 0 && s1Words[s1End].equals(s2Words[s2End])){
            s1End--;
            s2End--;
        }
        return s1End < start;
    }
}
