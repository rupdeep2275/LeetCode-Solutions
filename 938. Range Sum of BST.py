#Python:

class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        res = 0
        def dfs(root, low, high):
            nonlocal res #declare res as nonlocal to modify the outer variable
            if root is None:
                return
            if root.val >= low and root.val <= high:
                res += root.val
            if root.val > low:
                dfs(root.left, low, high)
            if root.val < high:
                dfs(root.right, low, high)
        dfs(root, low, high)
        return res

#Java:

class Solution {
    private int res;
    public int rangeSumBST(TreeNode root, int low, int high) {
        res = 0;
        dfs(root, low, high);
        return res;
    }
    private void dfs(TreeNode root, int low, int high){
        if(root == null) return;
        if(root.val >= low && root.val <= high) res += root.val;
        if(root.val > low) dfs(root.left, low, high);
        if(root.val < high) dfs(root.right, low, high);
    }
}
