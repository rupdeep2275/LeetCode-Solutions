class Solution {
    public int findBottomLeftValue(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        var res = 0;
        q.add(root);
        while(!q.isEmpty()){
            var size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                if(i == 0) res = node.val;
            }
        }
        return res;
    }
}
