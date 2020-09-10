import java.util.ArrayList;

public class Ggraph {

    public class node{
        public String name;
        public ArrayList<node> adj;
        public node parent;
        public boolean visited = false;

        public node(String name){
            this.name = name;
            this.adj = new ArrayList<node>();
        }
    }

    private ArrayList<node> adjList;

    public Ggraph(){
        this.adjList = new ArrayList<node>();
    }

    public void add(String[] names){
        if(names.length == 1){
            this.adjList.add(new node(names[0]));
            return;
        }

        node hold2 = (this.contains(names[1])) ? this.get(names[1]) : new node(names[1]);

        if(!this.contains(names[0])){
            node hold = new node(names[0]);
            hold2.parent = hold;
            hold.adj.add(hold2);
            this.adjList.add(hold);
        }else{

            hold2.parent = this.get(names[0]);
            this.get(names[0]).adj.add(hold2);
        }
    }

    public boolean contains(String name){
        for(node i : this.adjList){
            if(i.name.equals(name)){
                return true;
            }
        }
        return false;
    }

    public node get(String name){
        for(node i : this.adjList){
            if(i.name.equals(name)){
                return i;
            }
        }
        return null;
    }

    public void print(){
        for(node i : this.adjList){
            System.out.print(i.name + ": ");
            for(node j : i.adj){
                System.out.print(j.name + ",");
            }
            System.out.println("");
        }
    }

    public String buildOrder(){
        StringBuilder output = new StringBuilder();
        String hold =" ";
        for(node i : this.adjList){

            if(i.parent == null && i.adj.isEmpty()){
                output.append(i.name + ",");

            }else if(i.parent == null && !i.adj.isEmpty() && !i.visited){
                buildOrder(i, output);

            }else if(!i.visited && i.parent.visited){
                buildOrder(i, output);
            }

        }

        return output.toString() + hold;
    }

    private void buildOrder(node i, StringBuilder output){

        output.append(i.name);
        output.append(",");
        i.visited = true;

        for(node j : i.adj){
            if(!j.visited){
                buildOrder(j, output);
            }
        }

    }


}
