class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return checkPalindrome(i, j-1, s) || checkPalindrome(i+1, j, s);
            }
            i++;
            j--;
        }
        return true;
    }
    boolean checkPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
