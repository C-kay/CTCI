import java.util.Stack;

public class QueueStacks {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueStacks(){
        first = new Stack<Integer>();
        second = new Stack<Integer>();
    }

    public boolean push(int data){

        first.push(data);
        return true;
    }

    public int pop(){
        if(first.isEmpty()){
            return 0;
        }

        int hold = 0;
        while(!first.isEmpty()){
            hold = first.pop();

            if(!first.isEmpty()){
                second.push(hold);
            }
        }

        while(!second.isEmpty()){
            first.push(second.pop());
        }

        return hold;
    }

    public void print(){
        for(int i : first){
            System.out.println(i);
        }
    }

}
