/*
 * Sergio De Sa
 */


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class Venue {
//    private Car[] cars;
    private CheckPoint[] checkPoints;
//    Image car1;
//    ImageView imageView1;


    public Venue(){
//        cars = new Car[4];
        checkPoints = new CheckPoint[4];
//        car1 = new Image("blackcar.png");
//        imageView1 = new ImageView();
//        imageView1.setImage(car1);



        checkPoints[0] = new CheckPoint( 0, 0, 316, 4, "A");
        checkPoints[1] = new CheckPoint( 1000, 100, 787, 347, "B");
        checkPoints[2] = new CheckPoint( 500, 480, 345, 450, "C");
        checkPoints[3] = new CheckPoint( 10, 500, 10, 200, "D");
    }
    public double getCkPointX(int value){
        return checkPoints[value].getX();
    }
    public double getCkPointY(int value){
        return checkPoints[value].getY();
    }

    public CheckPoint getCheckPoints(int value){
        return checkPoints[value];
    }




}

