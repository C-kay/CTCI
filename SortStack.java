import java.util.Stack;

public class SortStack {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public SortStack(){
        first = new Stack<Integer>();
        second = new Stack<Integer>();
    }

    public boolean isEmpty(){
        return (first.isEmpty()) ? true : false;
    }

    public void push(int data){
        if(first.isEmpty() || first.peek() >=  data){
            first.push(data);
        }else if(first.peek() < data){

            while(first.peek() < data && !first.isEmpty()){
                second.push(first.pop());
            }
            first.push(data);

            for(int i : second){
                first.push(i);
            }
        }
    }

    public void pop(){
        first.pop();
    }

    public void peek(){
        first.peek();
    }

    public void print(){
        for(int i : first){
            System.out.println(i);
        }
    }

}
