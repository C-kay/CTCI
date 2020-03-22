public class Stack<T> {

    private class StackNode<T>{
        public T data;
        public  StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<Integer> top;
    private StackNode<Integer> min;

    private int minSec;

    public boolean isEmpty(){
        if(this.top == null){
            return true;
        }else{
            return false;
        }
    }

    public void push(int data){
        if(isEmpty()){
           this.top = new StackNode<Integer>(data);
           return;
        }
        StackNode<Integer> hold;

        hold= new StackNode<Integer>(data);
        hold.next = this.top;
        this.top = hold;

        if(this.min == null || this.minSec > data){
            hold= new StackNode<Integer>(data);
            hold.next = this.min;
            this.min = hold;
            this.minSec = data;
        }else{
            hold= new StackNode<Integer>(minSec);
            hold.next = this.min;
            this.min = hold;
        }

    }

    public int pop(){
        if(isEmpty()){
            return 0;
        }
         int data = this.top.data;
        this.top = this.top.next;

        this.min = this.min.next;

        return data;
    }

    public int peek(){
        if(isEmpty()){
            return 0;
        }
        return this.top.data;
    }

    public int min(){
        return min.data;
    }


    public void print(){
        StackNode<Integer> hold = this.top;

        while(hold != null){
            System.out.println(hold.data);
            hold = hold.next;
        }
    }

}
