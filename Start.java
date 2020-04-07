import java.util.*;
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

        h.createTree();
        h.print(h.root);
        System.out.println("-------------------------");
        System.out.println(h.isBST(h.root));
        System.out.println("-------------------------");

        isPalindrome(121);


    }

    public static boolean isPalindrome(int x) {
        if(x < 0 || x/10 == 0){
            return true;
        }
        int main = x;
        int pal = 0;

        pal = (pal * 10) + main % 10;
        main = main/10;

        while(main != 0){

            pal = (pal * 10) + main % 10;
            main = main/ 10;
        }
        System.out.println(pal);
        return pal == x;

    }






}
