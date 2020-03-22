import java.util.LinkedList;

public class SetOfStacks<T>{

    private class StackNode<T>{
        public StackNode<T> next;
        public T data;
        int size = 1;

        public StackNode(T data){
            this.data = data;
        }
    }

    int capacity;
    private LinkedList<StackNode<Integer>> set;

    public SetOfStacks(int capacity){
        this.capacity = capacity;
        set = new LinkedList<StackNode<Integer>>();
    }

    public boolean isEmpty(){
        if(set.size() == 0){
            return true;
        }else
            return false;
    }

    public void push(int data){
        if(isEmpty()){
            set.add(new StackNode<Integer>(data));
            return;
        }

        StackNode<Integer> top = set.peek();
        StackNode<Integer> hold;
        int hold2;
        int size = top.size;

        if(top.size != capacity){
            hold = new StackNode<Integer>(top.data);
            if(size == 1){
                top.data = data;
                top.next = hold;
            }else{
                hold. next =top.next;
                top.data = data;
                top.next = hold;
            }
        }else{
            hold = new StackNode<Integer>(data);
            set.add(hold);
        }
    }

    public int pop(){
        if(isEmpty()){
            return 0;
        }

        int data;
        StackNode<Integer> top = set.peek();
        data = top.data;

        if(top.next == null){
            top = null;
            set.pop();
        }else{
            top.next.size = top.size--;
            top = top.next;
        }

        return data;
    }

    public int peek(){
        if(isEmpty()){
            return 0;
        }

        StackNode<Integer> top = set.peek();
        return top.data;
    }

    public void print(){
        if(isEmpty()) {
            System.out.println("Stacks empty");
            return;
        };



        for (StackNode top : set){
            while(top != null){
                System.out.println(top.data);
                top = top.next;
            }
        }

    }


}
