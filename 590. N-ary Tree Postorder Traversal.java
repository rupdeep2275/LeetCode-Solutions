class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        dfs(root);
        return res;
    }
    void dfs(Node node){
        if(node == null) return;
        for(Node c : node.children) dfs(c);
        res.add(node.val);
    }
}
