
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.util.Random;

/**
 * Created by Matthew on 3/2/2017.
 */
public class Car {
    //attributes
    private int tire, engine, weight;
    private double speed;
    private int x,y;
    private Image image;
    private String name;

    //constructor
    public Car(int startX, int startY,Image i){
        calcSpeed();
        image = i;
        x = startX;
        y = startY;
    }

    //methods

    /**
     * Assigns a random value between 1 and 10 for tire, engine, and weight
     * Sets speed to the average of those 3 values
     */
    public void calcSpeed(){
        Random rand = new Random();
        tire = rand.nextInt(10)+1;
        engine = rand.nextInt(10)+1;
        weight = rand.nextInt(10)+1;
        speed = ((double)(tire+engine+weight))/3;
    }
    /**
     * Getters
     */
    public int getTire(){return tire;}
    public int getEngine(){return engine;}
    public int getWeight(){return weight;}
    public double getSpeed(){return speed;}
    public int getX(){return x;}
    public int getY(){return y;}
    public void setName(String n){name = n;}
    public String getName(){return name;}
    public String toString(){
        return "Name: "+name+ "\n   Tire Pressure: "+tire+"\n   Engine Horsepower: "+engine+"\n Weight: "+weight+"\n    Speed: "+speed*10+"mph";
    }

    public Image getCarImage(){
        return image;
    }


}