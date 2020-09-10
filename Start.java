import java.awt.*;
import java.util.*;
import java.util.LinkedList;

public class Start {

    public static void main(String[] args) {

//        LinkedList<Integer> num = new LinkedList<Integer>();
//        num.push(10);
//        num.push(4);
//        num.push(8);
//        num.push(2);
//        num.push(3);
//        num.push(1);
//
//        BinaryTree h = new BinaryTree();
//        BinaryTree g = new BinaryTree();
//
//        h.createTree();
//        g.createTree();

        String s="abc";

        ArrayList<String> hold = perm(s);

        for(String i : hold){
            System.out.println(i);
        }

    }

    public static ArrayList<String> perm(String s){
        if(s == null) return null;

        ArrayList<String> permutation = new ArrayList<String>();

        if(s.length() == 0){
            permutation.add("");
            return permutation;
        }

        char first = s.charAt(0);
        String remainder = s.substring(1);

        ArrayList<String> words = perm(remainder);

        for (String word : words){

            for (int j = 0; j <= word.length(); j++){
                String hold = moveLetter(word, first, j);
                permutation.add(hold);
            }
        }

        return permutation;

    }


    public static String moveLetter(String word, char first, int j){

        String left = word.substring(0, j);
        String right = word.substring(j);

        return left + first + right;

    }


    public  static HashSet<String> permuteBracket(int n){
        HashSet<String> result = new HashSet<>();

        if(n <= 0){
            result.add("");
            return result;
        }

        if(n == 1){
            result.add("()");
            return result;
        }

        HashSet<String> stuff = permuteBracket(n-1);

        for(String s : stuff){
            result.add("(" + s + ")");
            result.add("()" + s);
            result.add(s + "()");
        }
        return result;
    }


    public static ArrayList<String> permut(String s){

        if(s == null){return null;}

        ArrayList<String> permutations = new ArrayList<String>();
        if(s.length() == 0){
            permutations.add("");
            return permutations;
        }

        char first = s.charAt(0);
        String remaining = s.substring(1);

        ArrayList<String> words = permut(remaining);

        for(String word : words){
            for (int i=0; i<= word.length(); i++){
                String hold = moveLetter(word, i, first);
                permutations.add(hold);
            }
        }

        return permutations;
    }

    public static String moveLetter(String word, int i, char first){

        String start = word.substring(0,i);
        String end = word.substring(i);

        return start + first + end;
    }











    public static int magicIndex(int a[]){
        if(a.length == 0) return -1;
        return magicIndex(a, 0, a.length);
    }

    public static int magicIndex(int a[], int start, int end){

        if(start >= end) return -1;

        int index = (start + end)/2;

        if(a[index] == index){
            return index; 
        }else if(a[index] > index){
            return magicIndex(a, index +1, end);
        }else{
            return magicIndex(a, start, index-1);
        }

    }


    public static ArrayList<Point> path(boolean array [][]){

        ArrayList<Point> p = new ArrayList<Point>();
        if(path(array, p, array.length-1, array[0].length -1 )){
            return p;
        }

        return null;
    }

    public static boolean path(boolean a[][], ArrayList<Point> p,  int r, int c){
        if(r < 0 || c< 0 || !a[r][c]){
            return false;
        }

        boolean isOrigin = c==0 && r==0;

        if(isOrigin || path(a,p, --r, c) || path(a,p, r, --c)){
            Point n = new Point(r,c);
            p.add(n);
            return true;
        }
        return false;
    }

    public static int run(int steps){
        int arr[] = new int[steps+1];
        Arrays.fill(arr, -1);
        return run(steps, arr);
    }
    public static int run(int steps, int[] arr){
        if(steps < 0){
            return 0;
        }else if(steps == 0){
            return 1;
        }else if(steps > -1){
            return arr[steps];
        }else{
            arr[steps] = run(steps -1) + run(steps -2) + run(steps -3);
            return arr[steps];
        }
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || x / 10 == 0) {
            return true;
        }
        int main = x;
        int pal = 0;

        pal = (pal * 10) + main % 10;
        main = main / 10;

        while (main != 0) {

            pal = (pal * 10) + main % 10;
            main = main / 10;
        }
        System.out.println(pal);
        return pal == x;

    }


}
