import java.util.LinkedList;

public class Start {

    public static void main(String[] args) {

        LinkedList<Integer> num = new LinkedList<Integer>();
        num.push(10);
        num.push(4);
        num.push(8);
        num.push(2);
        num.push(3);
        num.push(1);

        BinaryTree h = new BinaryTree();

        h.minTreeh(num);
        System.out.println("-------------------------");
        h.print(h.root);
        System.out.println("-------------------------");

    }




}
