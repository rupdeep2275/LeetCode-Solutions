class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");
        while(word.length() < k){
            StringBuilder suffix = new StringBuilder();
            for(int i=0; i<word.length(); i++){
                suffix.append((char) (word.charAt(i)+1));
            }
            word.append(suffix);
        }
        return word.charAt(k-1);
    }
}
