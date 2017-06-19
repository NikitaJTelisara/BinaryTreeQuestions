import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

public class IsBalanced {

    public static void main(String[] args) {
        TreeNode j1 = new TreeNode(1);
        TreeNode j2 = new TreeNode(2);
        TreeNode j3 = new TreeNode(3);
        TreeNode j4 = new TreeNode(4);
        TreeNode j5 = new TreeNode(5);
        TreeNode j6 = new TreeNode(6);
        TreeNode j7 = new TreeNode(7);
        TreeNode j8 = new TreeNode(15);
        j1.left = j2;
        j1.right = j3;
        j2.left = j4;
        j2.right = j5;
        j3.left = j6;
        j3.right = j7;
        j7.left = j8;
        j7.right = new TreeNode(25);
        System.out.println(isBalanced(j1));


        TreeNode k1 = new TreeNode(1);
        TreeNode k2 = new TreeNode(2);
        TreeNode k3 = new TreeNode(3);
        TreeNode k4 = new TreeNode(4);
        TreeNode k5 = new TreeNode(5);
        TreeNode k6 = new TreeNode(6);
        TreeNode k7 = new TreeNode(7);
        k1.addChildren(k2);
        k1.addChildren(k3);
        k2.addChildren(k4);
        k2.addChildren(k5);
        k3.addChildren(k6);
        k3.addChildren(k7);
        System.out.println(isbalanced1(k1, k1.numberOfChildren));
    }

    /* when multip;e children*/
    public static boolean isBalanced(TreeNode n) {
        if (n == null) {
            return true;
        }
        if (isNodeBalanced(n)) {
            return isBalanced(n.left) && isBalanced(n.right);
        } else {
            return false;
        }
    }


    public static boolean isNodeBalanced(TreeNode n) {
        if (n == null) {
            return true;
        }
        if (n.left == null && n.right == null) {
            return true;
        } else if (n.left != null && n.right != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isbalanced1(TreeNode n, int numberOfChildren) {
        if (n == null) {
            return true;
        }
        if (isNodeBalanced1(n, numberOfChildren)) {
            for (TreeNode k : n.children) {
                if(!isbalanced1(k,numberOfChildren)){
                   return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    public static boolean isNodeBalanced1(TreeNode n, int numberOfChildren) {
        if (n == null) {
            return true;
        }
        else if (n.numberOfChildren == 0) {
            return true;
        }
        else if (n.numberOfChildren != numberOfChildren) {
            return false;
        }
        return true;
    }

}



