class Solution:
    def __init__(self):
        self.count = 0
    def averageOfSubtree(self, root: Optional[TreeNode]) -> int:
        def post_order(root):
            if not root:
                return 0, 0
            left_sum, left_count = post_order(root.left)
            right_sum, right_count = post_order(root.right)

            curr_sum = left_sum + root.val + right_sum
            curr_count = left_count + 1 + right_count

            if curr_sum // curr_count == root.val:
                self.count += 1
            
            return curr_sum, curr_count
        post_order(root)
        return self.count
