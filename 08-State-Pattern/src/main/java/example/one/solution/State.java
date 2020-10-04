package example.one.solution;

public abstract class State {
    public void handleRequest(){
        System.out.println("Shouldn't able to get here");
    }
}
