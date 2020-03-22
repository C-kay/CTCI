import java.util.LinkedList;

public class Graph {

    private class gNode{
        public String name;
        public LinkedList<gNode> adjacent;
        public boolean visited;

        public gNode(String name){
            this.name = name;
        }
    }

    public boolean route(gNode S, gNode E){

        if(S == null || S.adjacent.isEmpty()){
            return false;
        }

        S.visited = true;
        for(gNode i : S.adjacent){
            if(i.name == S.name){
                return true;
            }
            return route(i, E);
        }
        return false;
    }
}
