import java.util.ArrayList;
import java.util.LinkedList;
//thanks hammy snepie i love you
public class BinaryTree {

    private class Node{
        public int data;
        public Node right;
        public Node left;

        public Node(int data){
            this.data = data;
        }
    }

    public Node root;

    public void minTreeh(LinkedList<Integer> arr){
        if(arr.size() == 0) return;

        LinkedList<Integer> array = (LinkedList<Integer>) arr.clone();
        int index = array.size()/2;
        this.root = new Node(array.get(index));

        minTree(this.root, array);
    }

    public void minTree(Node root , LinkedList<Integer> array){
        if(root == null){
            root = new Node(array.pop());
            return;
        }

        //another change

        if(root.data <= array.peek()){
            minTree(root.left, array);
        }else{
            minTree(root.right, array);
        }
    }

    public void print(Node root){
        if(root == null) return;

        print(root.left);
        System.out.println(root.data);
        print(root.right);
    }
}
