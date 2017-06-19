import com.sun.xml.internal.fastinfoset.QualifiedName;
import sun.org.mozilla.javascript.internal.ast.NewExpression;

import java.util.ArrayList;

public class BinaryTreeQuestions {
    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(8);
        n.left = n1;
        n.right = n2;
        n1.left = n3;
        n1.right = n4;
        System.out.println("Is Balanced Tree " + isBalancesTree(n));
        n2.left = n5;
        n5.right = n6;
        n6.right = n7;
        System.out.println("Is Balanced Tree " + isBalancesTree(n));

        /* 4.2 Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

            40->20->50
            |
            v
            10->30->60->70

            */
        ArrayList nodes = new ArrayList();
        Node node1 = new Node(40);
        nodes.add(node1);
        Node node2 = new Node(20);
        nodes.add(node2);
        Node node3 = new Node(50);
        nodes.add(node3);
        Node node4 = new Node(10);
        nodes.add(node4);
        Node node5 = new Node(30);
        nodes.add(node5);
        Node node6 = new Node(60);
        nodes.add(node6);
        Node node7 = new Node(70);
        nodes.add(node7);

        int m[][] = {
                {0, 1, 0, 1, 0, 0, 0, 0},      //node1 40
                {0, 0, 1, 0, 0, 0, 0, 0},      //node1 20
                {0, 0, 0, 0, 0, 0, 0, 0},      //node1 50
                {0, 0, 0, 0, 0, 1, 0, 0},      //node1 10
                {0, 0, 0, 0, 0, 0, 1, 0},      //node1 30
                {0, 0, 0, 0, 0, 0, 0, 1},      //node1 60
                {0, 0, 0, 0, 0, 0, 0, 0},      //node1 70
        };

        /* check between 20 and 30 */
        boolean result = directRootExists(node2, node5, nodes, m);
        System.out.println(result);
        /* check between 40 and 60 */
        result = directRootExists(node1, node6, nodes, m);
        System.out.println(result);

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode head = createBST(arr, 0, arr.length - 1);
        System.out.println("Print Binary Tree");
        printBST(head);
        System.out.println("End of tree");

        createLevelArrayList(n);
        System.out.println("check is BST");
        TreeNode n15 = new TreeNode(5);
        n15.left = new TreeNode(4);
        n15.right = new TreeNode(6);
        boolean r = checkBST(n15);
        System.out.println("is BST " + r);

        n15 = new TreeNode(5);
        n15.left = new TreeNode(11);
        n15.right = new TreeNode(6);
        r = checkBST(n15);
        System.out.println("is BST " + r);

        System.out.println("Check issubTree");
        Boolean result1 = checkSubtree(n, n3);
        System.out.println("n3" + " is subtree of " + "n " + result1);

        TreeNode n8 = new TreeNode(2);
        n8.left = new TreeNode(0);
        n8.right = new TreeNode(3);


        result1 = checkSubtree(n, n8);
        System.out.println("n" + " is subtree of " + "n8 " + result1);

        TreeNode n11 = new TreeNode(2);
        n11.left = new TreeNode(0);
        n11.right = new TreeNode(11);
        result1 = checkSubtree(n, n11);
        System.out.println("n" + " is subtree of " + "n11 " + result1);

        /* Print top view Of tree */

        TreeNode j1 = new TreeNode(1);
        TreeNode j2 = new TreeNode(2);
        TreeNode j3 = new TreeNode(3);
        TreeNode j4 = new TreeNode(4);
        TreeNode j5 = new TreeNode(5);
        TreeNode j6 = new TreeNode(6);
        TreeNode j7 = new TreeNode(7);
        j1.left =j2;
        j2.left =j3;
        j2.right =j6;
        j1.right =j4;
        j4.left = j5;
        j4.right = j7;
        printTopViewOfBR(j1);

    }

    public static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /* 4.1 check if a binary tree is balanced */
    public static boolean isBalancesTree(TreeNode node) {
        if (getHeight(node) == -1) {
            return false;
        }
        return true;
    }

    public static ArrayList<Node> findNeighbours(Node n1, ArrayList<Node> nodes, int m[][]) {
        int indexofNode = -1;
        ArrayList<Node> neighbours = new ArrayList<Node>();
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i) == n1) {
                indexofNode = i;
            }
            if (indexofNode != -1) {
                for (int j = 0; j < m[0].length; j++) {
                    if (m[indexofNode][j] == 1) {
                        neighbours.add(nodes.get(j));
                    }
                }
            }

        }
        return neighbours;
    }

    /* using bfs (can */
    public static boolean directRootExists(Node n1, Node n2, ArrayList<Node> nodes, int m[][]) {
        Queue q = new Queue();
        n1.visited = true;
        q.enQueue(n1);
        while (!q.isEmpty()) {
            Node n = q.deQueue();
            if (n.data == n2.data) {
                return true;
            }
            ArrayList<Node> neighbours = findNeighbours(n, nodes, m);
            for (int i = 0; i < neighbours.size(); i++) {
                n = neighbours.get(i);
                if (n != null && !n.visited) {
                    n.visited = true;
                    q.enQueue(neighbours.get(i));
                }
            }
        }
        return false;
    }

    /* 4.3 Given a sorted array create a binary search tree.*/

    public static TreeNode createBST(int[] arr, int lowerIndex, int higherIndex) {
        if (lowerIndex > higherIndex) {
            return null;
        }
        int mid = lowerIndex + (higherIndex - lowerIndex) / 2;
        TreeNode head = new TreeNode(arr[mid]);
        head.left = createBST(arr, lowerIndex, mid - 1);
        head.right = createBST(arr, mid + 1, higherIndex);
        return head;
    }

    public static void printBST(TreeNode head) {
        if (head == null) {
            return;
        }
        /* pre order */
        System.out.println(head.data);
        printBST(head.left);
        printBST(head.right);

    }

    /* 4.4 Given a binary tree, design an algorithm which creates a list of all the nodes at
    each dept  */

    public static void createLevelArrayList(TreeNode binaryTreeNode) {
        ArrayList<ArrayList<Node>> lists = new ArrayList<ArrayList<Node>>();
        lists = createLevelArrayList(binaryTreeNode, lists, 0);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println("Level :" + i);
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.println(lists.get(i).get(j).data);
            }
        }
    }

    public static ArrayList<ArrayList<Node>> createLevelArrayList(TreeNode binaryTreeNode, ArrayList<ArrayList<Node>> lists, int level) {
        ArrayList<Node> list = null;
        if (lists.size() == level) {
            list = new ArrayList<Node>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(new Node(binaryTreeNode.data));
        if (binaryTreeNode.left != null) {
            createLevelArrayList(binaryTreeNode.left, lists, level + 1);
        }
        if (binaryTreeNode.right != null) {
            createLevelArrayList(binaryTreeNode.right, lists, level + 1);
        }
        return lists;
    }

    /* incorrect solution */
    public static boolean checkBST(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (checkEachNode(node)) {  // use checkBST here
            return (checkBST(node.left) && checkBST(node.right));
        }
        return false;
    }
    public static boolean checkEachNode(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.left != null) {
            if (node.left.data > node.data) {
                return false;
            }
        }
        if (node.right != null) {
            if (node.right.data <= node.data) {
                return false;
            }
        }
        return true;
    }


    /*4.8 algorithm to decide if T2 is a subtree of Tl.*/

    public static boolean checkSubtree(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return false;
        }
        if (isMatch(t1, t2)) {
            return true;
        }
        return (checkSubtree(t1.left, t2) || (checkSubtree(t1.right, t2)));
    }

    public static boolean isMatch(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.data != t2.data) {
            return false;
        }
        return (isMatch(t1.left, t2.left) && isMatch(t1.right, t2.right));
    }

    /*public static ArrayList<int[]> returnPathWithSum(TreeNode binaryTreeNode,int sum){
        while(binaryTreeNode != null){

        }
    */


    /* bad solution*/
    public static void printTopViewOfBR(TreeNode binaryTreeNode){
        TreeNode head = binaryTreeNode;
        Node n = new Node(binaryTreeNode.data);
        Stack s = new Stack();
        Queue q = new Queue();
        s.push(n.data);
        while(head.left != null){
            head = head.left;
            s.push(head.data);
        }
        System.out.println("Printing left Tree");
        while(!s.isEmpty()){
            System.out.println(s.pop().data);
        }
        head = binaryTreeNode;
        while(head.right != null){
            head = head.right;
           q.enQueue(new Node(head.data));
        }
        System.out.println("Printing right Tree");
        while(!q.isEmpty()){
            System.out.println(q.deQueue().data);
        }
    }
}
