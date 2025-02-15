class Solution {
    List<String> res;
    int n;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        this. n = n;
        dfs("(", 1, 0);
        return res;
    }
    void dfs(String str, int open, int close){
        if(str.length() == 2 * n) res.add(str);
        if(open < n) dfs(str + "(", open + 1, close);
        if(close < open) dfs(str + ")", open, close + 1);
    }
}
