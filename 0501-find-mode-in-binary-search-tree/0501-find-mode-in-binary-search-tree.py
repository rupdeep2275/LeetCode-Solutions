# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        freq_map = defaultdict(int)
        def pre_order(node):
            if not node:
                return
            freq_map[node.val] += 1
            pre_order(node.left)
            pre_order(node.right)
        pre_order(root)
        max_freq = max(freq_map.values())
        return [x for x in freq_map if freq_map[x] == max_freq]
        
        
        