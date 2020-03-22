import java.sql.Array;
import java.util.HashSet;
import java.util.List;

public class LinkedList {

    public class Node {
        public Node(String data){
            this.data = data;
            this.next = null;
        }

        public Node(int data){
            this.data1 = data;
            this.next = null;
        }
        public Node next;
        public String data;
        public int data1;
    }

    private Node Head;
    private Node p;
    private Node p2;

    public LinkedList(){
        this.Head = null;
        this.p = this.p2 = Head;
    }

    //search method
    public boolean search(String data){

        this.p = this.Head;
        if (this.isEmpty()){
            System.out.println("List is Empty");
            return false;
        }

        while(this.p != null){
            if (this.p.data.equals(data)){
                return true;
            }
            this.p = this.p.next;
        }

        return false;
    }

    //append method
    public void addNode(String data){
        Node newNode= new Node(data);
        if (this.isEmpty()){
            this.Head =  newNode;
            return;
        }else {
            newNode.next = this.Head;
            Head = newNode;
        }
    }

    public void addNode(int data){
        Node newNode= new Node(data);
        if (this.isEmpty()){
            this.Head =  newNode;
            return;
        }else {
            newNode.next = this.Head;
            Head = newNode;
        }
    }

    //Method to check if empty
    public boolean isEmpty(){
        if (this.Head == null){
            return true;
        }else{
            return false;
        }
    }

    //method to print
    public void print(){
        if (this.isEmpty()){
            System.out.println("The List is Empty");
            return;
        }

        this.p = this.Head;
        while (this.p != null){
            System.out.println(this.p.data1);
            this.p = this.p.next;
        }

        return;
    }

    //delete method


    public void pop(){
        this.p = this.Head;

        if (this.Head == null){
            System.out.println("List is Empty");
            return;
        }

        if (this.Head.next == null){
            this.Head = null;
            return;
        }

        this.pop(this.p);
        return;
    }
    public void pop(Node head){

        if (head.next.next == null){
            head.next = null;
            return;
        }else{
            this.pop(head.next);
        }

        return;
    }

    public void reverse(){
        if(this.Head == null || this.Head.next == null){
            return;
        }

        Node back = this.Head;
        Node center = back.next;
        Node front = center.next;

        center.next = back;
        back.next = null;
        back = center;
        center = front;
        front = front.next;

        while (center != null){
            center.next = back;
            back = center;
            center = front;

            if(front != null){
                front = front.next;
            }
        }
        this.Head = back;
    }

    public LinkedList dup(){

        Node p = this.Head;
        HashSet<String> hold = new HashSet<String>();

        while(p != null){
            hold.add(p.data);
            p = p.next;
        }

        LinkedList noDup = new LinkedList();

        for (String i : hold){
            noDup.addNode(i);
        }

        return noDup;
    }

    public String kElement(int k){
        Node p = this.Head;
        int length = 0, index = 0;

        while(p != null){

            length++;
            p = p.next;
        }

        index = length - k;
        p = this.Head;
        while (index > 0){
            index --;
            p = p.next;
        }
        return p.data;
    }

    public LinkedList sum(LinkedList other){

        Node p1 = this.Head;
        Node p2 = other.Head;
        int carrier = 0;
        LinkedList hold = new LinkedList();

        while (p1 != null || p2 != null){

            if(p1 == null){
                this.addNode(0);
                p2 = p2.next;

            }else if(p2 == null){
                other.addNode(0);
                p1 = p1.next;
            }else{
                p2 = p2.next;
                p1 = p1.next;
            }
        }

        p1 = this.Head;
        p2 = other.Head;

        while (p1 != null || p2 != null ){

            carrier = p1.data1 + p2.data1 + carrier;

            hold.addNode(carrier % 10);
            carrier = carrier / 10;
            carrier = carrier % 10;

            p1 = p1.next;
            p2 = p2.next;
        }

        return hold;
    }

    public int intersect(LinkedList b){

        HashSet<Integer> hold = new HashSet<Integer>();
        Node p = this.Head;
        Node p2 = b.Head;

        while(p != null){
            hold.add(p.data1);
        }

        while(p2 != null){

            if(hold.contains(p2.data1)){
                return p2.data1;
            }
        }

        return 0;
    }

    public LinkedList partition(int patition){

        LinkedList less = new LinkedList();
        LinkedList more = new LinkedList();
        Node p = this.Head;

        while (p != null){

            if(p.data1 < patition){

                less.addNode(p.data1);
            }

            if(p.data1 >= patition){

                more.addNode(p.data1);
            }

            p = p.next;
        }

        p = less.Head;
        while(p.next != null){
            p = p.next;
        }

        p.next = more.Head;

        return less;
    }



}
