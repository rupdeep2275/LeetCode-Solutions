class Solution {
    Set<Integer> set = new HashSet<>();
    int k;
    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }
    boolean dfs(TreeNode root){
        if(root == null) return false;
        else if(set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left) || dfs(root.right);
    }
}
