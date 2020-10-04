package example.one;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observerList=new ArrayList<Observer>();

    abstract void setState(String state);
    abstract String getState();

    public void attach(Observer observer){
        observerList.add(observer);
    }

    public void detach(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObservers(){
        for(Observer observer: observerList){
            observer.update();
        }
    }
}
