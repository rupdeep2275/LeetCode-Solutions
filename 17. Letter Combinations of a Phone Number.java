class Solution {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        private String digits;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return combinations;
        this.digits = digits;
        backtrack(new StringBuilder(), 0);
        return combinations;
    }
    private void backtrack(StringBuilder sb, int i){
        if(sb.length() == digits.length()){
            combinations.add(sb.toString());
            return;
        }
        String possibleLetters = letters.get(digits.charAt(i));
        for(char letter : possibleLetters.toCharArray()){
            sb.append(letter);
            backtrack(sb, i+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
