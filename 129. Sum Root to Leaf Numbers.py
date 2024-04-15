#Python:

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        res = 0
        def dfs(node, num):
            nonlocal res
            if node is None:
                return
            num = num * 10 + node.val
            if node.left is None and node.right is None:
                res += num
            dfs(node.left, num)
            dfs(node.right, num)
        dfs(root, 0)
        return res


#Java:

class Solution {
    int res;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode node, int num){
        if(node == null) return;
        num = num * 10 + node.val;
        if(node.left == null && node.right == null){
            res += num;
        }
        dfs(node.left, num);
        dfs(node.right, num);
    }
}
