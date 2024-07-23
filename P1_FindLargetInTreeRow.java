//Tc: O(n)
//Sc: O(h)

class Solution {
    private List<Integer> result = new ArrayList<>();
    private void dfs(TreeNode node, int level) {
        if(node == null) return;
        if(result.size() == 0 || result.size() < level + 1)
            result.add(node.val);
        else
            result.set(level, Math.max(node.val, result.get(level)));
        
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return result;
    }
}