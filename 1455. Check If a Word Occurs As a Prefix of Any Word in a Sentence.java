class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        var words = sentence.split(" ");
        for(var x=0; x<words.length; x++){
            var j = 0;
            for(var i=0; i<words[x].length(); i++){
                if(words[x].charAt(i) == searchWord.charAt(j++)){
                    if(j == searchWord.length()) return x + 1;
                }
                else break;
            }
        }
        return -1;
    }
}
