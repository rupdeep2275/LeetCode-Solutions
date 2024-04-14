#Python:

class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        res = 0
        def dfs(root):
            nonlocal res
            if root is None:
                return
            if root.left and root.left.left is None and root.left.right is None:
                res += root.left.val
            dfs(root.left)
            dfs(root.right)
        dfs(root)
        return res

#Java:

class Solution {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        if(root.left != null && root.left.left == null && root.left.right == null) res += root.left.val;
        dfs(root.left);
        dfs(root.right);
    }
}
