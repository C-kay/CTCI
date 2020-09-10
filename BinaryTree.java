import java.util.ArrayList;
import java.util.LinkedList;

//thanks hammy snepie i love you
public class BinaryTree {

    private class Node {
        public int data;
        public Node right;
        public Node left;
        public boolean visited;

        public Node(int data) {
            this.data = data;
        }
    }

    // hamza is cool not
    public Node root;

    public void minTreeh(int arr[]) {
        if (arr.length == 0) return;

        this.root = minTree(arr, 0, arr.length - 1);

    }

    public Node minTree(int[] array, int start, int end) {
        if (end < start) return null;

        int index = (end + start) / 2;

        Node n = new Node(array[index]);

        n.left = minTree(array, start, index - 1);
        n.right = minTree(array, index + 1, end);

        return n;
    }

    public void print(Node root) {
        if (root == null) return;

        print(root.left);
        System.out.println(root.data);
        print(root.right);
    }

    public LinkedList<LinkedList<Node>> listOfDepth() {
        LinkedList<LinkedList<Node>> arr = new LinkedList<LinkedList<Node>>();

        listOfDepth(this.root, arr, 0);

        return arr;
    }

    public void listOfDepth(Node root, LinkedList<LinkedList<Node>> arr, int level) {

        if (root == null) return;

        LinkedList<Node> hold = new LinkedList<Node>();
        hold.add(root);

        if (arr.size() == level) {
            arr.add(hold);
        } else {
            arr.get(level).add(root);
        }

        listOfDepth(root.right, arr, level + 1);
        listOfDepth(root.left, arr, level + 1);
    }


    public boolean checkBalance() {
        int left = 0;
        int right = 0;

        checkBalance(this.root, left, right);
        System.out.println("left: " + left + "  " + "right: " + right);
        return (Math.abs(left - right) < 2) ? true : false;
    }

    public void checkBalance(Node root, int right, int left) {
        if (root == null) {
            return;
        }

        if (root.left != null) checkBalance(root.left, left++, right);

        if (root.right != null) checkBalance(root.right, right++, left);
    }

    public void createTree() {

        this.root = new Node(9);
        Node left = this.root.left = new Node(7);
        Node right = this.root.right = new Node(14);


        right.left = new Node(28);
        right.right = new Node(30);

        left.left = new Node(34);
        left.right = new Node(50);
    }

    public boolean isBST(Node root) {
        if (root == null) return true;

        if (root.left != null && root.right != null) {

            if (root.left.data <= root.data && root.right.data > root.data) {
                return isBST(root.left) && isBST(root.right);
            } else {
                return false;
            }
        }
        if (root.left != null) {
            if (root.left.data <= root.data) {
                return isBST(root.left);
            } else {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.data > root.data) {
                return isBST(root.right);
            } else {
                return false;
            }
        }
        return true;
    }

    public void successor(Node root) {
        if (root == null) {
            return;
        }
        if (root.right == null) {
            System.out.println(root.left.data);
            return;
        }

        successor(root.right);
        successor(root.left);
        System.out.println();
    }

    public boolean checkSubTree(Node T1, Node T2) {
        Node pT1 = findNode(T1, T2);

        return checkIfSame(pT1, T2);

    }

    public Node findNode(Node pT1, Node T2) {

        if (pT1 == null || T2 == null) {
            return null;
        }

        if (pT1.data == T2.data) {
            return pT1;
        }

        findNode(pT1.left, T2);
        findNode(pT1.right, T2);

        return null;
    }

    public boolean checkIfSame(Node pT1, Node T2){

        if(pT1 == null && T2 == null){
            return true;
        }

        if(pT1 == null || T2 == null){
            return false;
        }

        if(pT1.data != T2.data){
            return false;
        }

        return checkIfSame(pT1.left, T2.left) && checkIfSame(pT1.right, T2.right);
    }


}
