class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;

        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        if(left==right) return root; //If its a leaf node (null==null)
      
        root.left=right;
        root.right=left;
        return root;
    }
}