class Solution {
    public String compressedString(String word) {
        var i = 0;
        var comp = new StringBuilder();
        while(i < word.length()){
            var j = i;
            while(j - i + 1 < 9 && j + 1 < word.length() && word.charAt(j) == word.charAt(j+1)) j++;
            comp.append(j-i+1);
            comp.append(word.charAt(i));
            i = j+1;
        }
        return comp.toString();
    }
}
