class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0, m = word1.length(), n = word2.length();
        var sb = new StringBuilder();
        while(i < m && j < n){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        while(i < m) sb.append(word1.charAt(i++));
        while(j < n) sb.append(word2.charAt(j++));
        return sb.toString();
    }
}
