class Solution {
    public boolean checkValidString(String s) {
        int i = 0, j = s.length() - 1, openCount = 0, closeCount = 0;
        while(i < s.length()){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(c1 == '(' || c1 == '*') openCount++;
            else openCount--;
            if(c2 == ')' || c2 == '*') closeCount++;
            else closeCount--;
            if(openCount < 0 || closeCount < 0) return false;
            i++;
            j--;
        }
        return true;
    }
}
