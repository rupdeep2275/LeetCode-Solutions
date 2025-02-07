class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int preorderIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
        return arrayToTree(preorder, 0, preorder.length-1);
    }
    TreeNode arrayToTree(int[] preorder, int lo, int hi){
        if(lo > hi) return null;
        int val = preorder[preorderIdx++];
        TreeNode root = new TreeNode(val);
        root.left = arrayToTree(preorder, lo, map.get(val) - 1);
        root.right = arrayToTree(preorder, map.get(val) + 1, hi);
        return root;
    }
}
