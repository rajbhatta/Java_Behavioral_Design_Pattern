## Introduction ##
 Mediator is a behavioral design pattern that lets you reduce chaotic dependencies between objects. 
 The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object.
  <img src="mediator.png" />

## Concept in Java ##
- When loose coupling is required
- When all application is routed

```java
java.util.Timer
java.lang.reflect.Method#invoke()
```
 
## UML ##
<img src="mediator_uml.png"/>

- Mediator is an interface or abstract class in most cases.
- If it mediator is an abstract class then it is extended inside concreteMediator
- ConcreteCollegue1 and ConcreteCollege2 don't communicate directly with each other but through mediator.

- Mediator – defines the interface for communication between Colleague objects
- ConcreteMediator – implements the Mediator interface and coordinates communication between Colleague objects. It is aware of all of the Colleagues and their purposes with regards to inter-communication.
- Colleague – defines the interface for communication with other Colleagues through its Mediator
- ConcreteColleague – implements the Colleague interface and communicates with other Colleagues through its Mediator

## Example ##
### Example1 ###
```java
package example.one;

//Colleague
public interface Command {
    void execute();
}

```

```java
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

```

```java
package example.one;

import java.util.ArrayList;
import java.util.List;

//Mediator can be concrete class
public class Mediator {
    private List<Light> lights=new ArrayList<>();

    public void registerLight(Light light){
        lights.add(light);
    }

    public void turnOnAllLights(){
        for(Light light: lights){
            if(!light.isOn()){
                light.toogle();
            }
        }
    }

    public void turnOffAllLights(){
        for(Light light: lights){
            if(!light.isOn()){
                light.toogle();
            }
        }
    }
}

```

```java
package example.one;

public class OnCommand implements Command {

    private Light light;

    public OnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

```

```java
package example.one;

public class TurnOffAllLightsCommand implements Command {
    private  Mediator mediator;

    public TurnOffAllLightsCommand(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void execute() {
        mediator.turnOffAllLights();
    }
}

```

```java
package example.one;

//Concrete command
public class TurnOnAllLightsCommand implements Command {

    private Mediator mediator;

    public TurnOnAllLightsCommand(Mediator mediator) {
        this.mediator=mediator;
    }

    @Override
    public void execute() {
        mediator.turnOnAllLights();
    }
}

```

```java
package example.one;

import java.util.List;

public class AllLightsCommand implements Command {

    private List<Light> lights;

    public AllLightsCommand(List<Light> lights) {
        this.lights = lights;
    }


    @Override
    public void execute() {
        for(Light light: lights){
            if(light.isOn()){
                light.toogle();
            }
        }
    }
}

```

```java
package example.one;

public class MediatorDemo {
    public static void main(String[] args){
        Mediator mediator=new Mediator();

        Light bedroomLight=new Light("Bedroom");
        Light kitchenLight=new Light("Kitchen");

        mediator.registerLight(bedroomLight);
        mediator.registerLight(kitchenLight);

        Command turnOnAllLightsCommand=new TurnOnAllLightsCommand(mediator);
        turnOnAllLightsCommand.execute();

        Command turnOffAllLightsCommand=new TurnOffAllLightsCommand(mediator);
        turnOffAllLightsCommand.execute();
    }
}
```