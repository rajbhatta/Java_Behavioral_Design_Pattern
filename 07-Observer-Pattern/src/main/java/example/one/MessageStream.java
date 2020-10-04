package example.one;

import java.util.ArrayDeque;
import java.util.Deque;

//Concrete subject
public class MessageStream extends Subject {

    private Deque<String> messageHistory=new ArrayDeque<String>();


    void setState(String message) {
        messageHistory.add(message);
        this.notifyObservers();
    }

    String getState() {
        return messageHistory.getLast();
    }
}
