/*
 * Sergio De Sa
 */

package sample;

import javafx.scene.shape.QuadCurveTo;

public class CheckPoint extends QuadCurveTo{

    private String name;

    public CheckPoint(double controlX,
                      double controlY,
                      double x,
                      double y,
                      String name) {
        super(controlX, controlY, x, y);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
