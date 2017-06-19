import java.util.ArrayList;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;
    ArrayList<TreeNode> children = new ArrayList<TreeNode>();
    int numberOfChildren = 0;

    public TreeNode(int data){
        this.data = data;
    }

    public void addChildren(TreeNode n){
         this.children.add(n);
         numberOfChildren++;
    }

    public void removeChildren(TreeNode n){
        this.children.remove(n);
        numberOfChildren--;
    }
}
