/*
 * Sergio De Sa
 * Class used to construct the Venue
 * The Venue is construct with CheckPoints
 */


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;


public class Venue {

    // Array to hold the CheckPoints
    private CheckPoint[] checkPoints;


    // The constructor of Venue.
    public Venue(){

        checkPoints = new CheckPoint[4];

        checkPoints[0] = new CheckPoint( 100, 100, 316, 144, "A");
        checkPoints[1] = new CheckPoint( 500, 200, 527, 287, "B");
        checkPoints[2] = new CheckPoint( 500, 500, 345, 495, "C");
        checkPoints[3] = new CheckPoint( 75, 500, 100, 280, "D");
    }

    /**
     * Return CheckPoints from the array checkPoints
     * @param value the array position to return
     * @return the CheckPoint
     */
    public CheckPoint getCheckPoints(int value){
        return checkPoints[value];
    }
}

