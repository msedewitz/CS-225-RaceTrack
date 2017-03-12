
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
    private double time;

    //constructor
    public Car(int startX, int startY,Image i){
        calcSpeed();
        image = i;
        x = startX;
        y = startY;
        time = 0;
    }

    //methods

    /**
     * Assigns a random value between 1 and 10 for tire, engine, and weight
     * Sets speed to the average of those 3 values
     */
    public void calcSpeed(){
        Random rand = new Random();
        tire = rand.nextInt(100)+1;
        engine = rand.nextInt(100)+1;
        weight = rand.nextInt(100)+1;
        speed = ((double)(tire+engine+weight))/3;

        //round speed to 2 decimal places
        speed = speed*100;
        speed = Math.round(speed);
        speed = speed/100;
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
    public Image getCarImage(){return image;}
    public double getTime(){return time;}

    /**
     * set the name of the car
     * @param n, the car name
     */
    public void setName(String n){name = n;}

    /**
     * Set time for car to finish
     * @param t, time it takes for the car to complete the race
     */
    public void setTime(double t){time=t;}

    /**
     * create a string of all important car values
     * can only be called after a setName() is called
     * @return
     */
    public String toString(){
        return "Name: "+name+ "\n  Tire Pressure: "+tire+"psi\n  Engine Horsepower: "+engine+"00\n  Weight: "+weight+"00lbs\n  Speed: "+speed+"mph\n\n";
    }

    /**
     * returns a string with the cars name, and the time it took to complete the race
     * can only be called after setName() and setTime() are both called
     * @return a String with name and time
     */
    public String getResult(){
        int min = (int)time/60;
        double sec = time%60;
        sec = sec*100;
        sec = Math.round(sec);
        sec = sec/100;

        return name+ " :: "+min+":"+sec+"\n";
    }

}