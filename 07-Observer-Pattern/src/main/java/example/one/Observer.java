package example.one;

public abstract class Observer {

    //Reference of the subject is stored here
    protected Subject subject;
    abstract void update();
}
