package example.two;

import java.util.Iterator;

public class IteratorDemo {
    public static void main(String [] args){
        BikeRepository repo=new BikeRepository();

        repo.addBike("A");
        repo.addBike("B");
        repo.addBike("C");

        Iterator<String> bikeIterator= repo.iterator();

        for(String bike: repo){
            System.out.println(bike);
        }

    }
}
