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



        checkPoints[0] = new CheckPoint( 100, 100, 316, 144, "A");
        checkPoints[1] = new CheckPoint( 500, 200, 527, 287, "B");
        checkPoints[2] = new CheckPoint( 500, 500, 345, 495, "C");
        checkPoints[3] = new CheckPoint( 75, 500, 100, 280, "D");
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

