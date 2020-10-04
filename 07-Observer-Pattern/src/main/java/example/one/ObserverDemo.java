package example.one;

public class ObserverDemo {
    public static void main(String [] args){
        Subject subject=new MessageStream();

        PhoneClient phoneClient=new PhoneClient(subject);
        phoneClient.addMessage("hello");

        TabletClient tabletClient=new TabletClient(subject);
        tabletClient.addMessage("hello another");

    }
}
