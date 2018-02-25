package BST;

import java.util.HashSet;

public class printTopViewOfBTree {

    public static void main(String[] args) {
        TreeNode j1 = new TreeNode(1);
        TreeNode j2 = new TreeNode(2);
        TreeNode j3 = new TreeNode(3);
        TreeNode j4 = new TreeNode(4);
        TreeNode j5 = new TreeNode(5);
        TreeNode j6 = new TreeNode(6);
        TreeNode j7 = new TreeNode(7);
        TreeNode j8 = new TreeNode(15);
        j3.left = j2;
        j3.right = j5;
        j2.left = j1;
        j5.left = j4;
        j5.right = j6;
        j6.right = j7;
        TreeNode j44 = new TreeNode(4);
        TreeNode j55 = new TreeNode(55);
        TreeNode j66 = new TreeNode(6);
        j55.left = j44;
        j55.right = j66;
        printTopView(j3);
    }

    public static void printTopView(TreeNode treeNode1) {
        if (treeNode1 == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        QItem qt = new QItem();
        qt.heightDistance = 0;
        qt.node = treeNode1;
        Queue q = new Queue();
        q.enqueue(qt);
        while (!q.isEmpty()) {
            QItem qt1 = q.dequeue();
            if (!set.contains(qt1.heightDistance)) {
                set.add(qt1.heightDistance);
                System.out.println(qt1.node.data);
            }
            if (qt1.node.left != null) {
                QItem qtl = new QItem();
                qtl.heightDistance = qt1.heightDistance - 1;
                qtl.node = qt1.node.left;
                q.enqueue(qtl);
            }
            if (qt1.node.right != null) {
                QItem qtr = new QItem();
                qtr.heightDistance = qt1.heightDistance + 1;
                qtr.node = qt1.node.right;
                q.enqueue(qtr);
            }
        }
    }
}
