#Python:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        count = 0
        def dfs(node, max_parent_val):
            nonlocal count
            if not node:
                return 0
            if node.val >= max_parent_val:
                count += 1
                max_parent_val = node.val
            dfs(node.left, max_parent_val)
            dfs(node.right, max_parent_val)
        dfs(root, -10_000)
        return count


#Java:

# /**
#  * Definition for a binary tree node.
#  * public class TreeNode {
#  *     int val;
#  *     TreeNode left;
#  *     TreeNode right;
#  *     TreeNode() {}
#  *     TreeNode(int val) { this.val = val; }
#  *     TreeNode(int val, TreeNode left, TreeNode right) {
#  *         this.val = val;
#  *         this.left = left;
#  *         this.right = right;
#  *     }
#  * }
#  */
class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, -10_001);
        return count;
    }
    void dfs(TreeNode node, int maxParentVal){
        if(node == null) return;
        else if(node.val >= maxParentVal){
            count++;
            maxParentVal = node.val;
        }
        dfs(node.left, maxParentVal);
        dfs(node.right, maxParentVal);
    }
}
