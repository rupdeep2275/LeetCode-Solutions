//Java:

class Solution {
    public boolean closeStrings(String word1, String word2) {
        var freq1 = new int[26];
        var freq2 = new int[26];
        for(var c : word1.toCharArray()) freq1[c-'a']++;
        for(var c : word2.toCharArray()) freq2[c-'a']++;
        for(var i=0; i<26; i++){
            if((freq1[i] == 0) != (freq2[i] == 0)) return false;
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for(var i=0; i<26; i++){
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
}

//Python:

class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        count1, count2 = Counter(word1), Counter(word2)
        return set(word1) == set(word2) and sorted(count1.values()) == sorted(count2.values())

