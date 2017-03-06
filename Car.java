package sample;

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
    private ImageIcon image;
    private String name;

    //constructor
    public Car(int startX, int startY){
        calcSpeed();
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
        speed = (tire+engine+weight)/3;
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
    public String getName(){return name;}

    public String toString(){
        return "Name: "+name+ "Tire: "+tire+" Engine: "+engine+" Weight: "+weight+" Speed: "+speed+" X: "+x+" Y: "+y;
    }


}