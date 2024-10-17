class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    int height(TreeNode root){
        if(root == null) return 0;

        var lh = height(root.left);
        if(lh == -1) return -1;
        var rh = height(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }
}
