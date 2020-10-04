package example.one;

//receiver
public class Light {
    private boolean isOn=false;

    private String location="";

    public Light() {
    }

    public Light(String location) {
        this.location = location;
    }

    public boolean isOn(){
        return isOn;
    }

    public void toogle(){
        if(isOn){
            off();
        }
    }

    public void off(){
        System.out.println("Light off");
    }

    public void on(){
        System.out.print("Light on");
    }
}
