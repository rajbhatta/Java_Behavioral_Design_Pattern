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
