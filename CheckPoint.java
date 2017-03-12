/*
 * Sergio De Sa
 * Class used to construct a CheckPoints
 * each CheckPoints is constructed
 * from a single QuadCurveTo.
 */


import javafx.scene.shape.QuadCurveTo;

public class CheckPoint extends QuadCurveTo{

    private String name; // the name to CheckPoint

    /**
     * constructor
     * @param controlX the x coordinate control point
     * @param controlY the y coordinate control point
     * @param x the x coordinate end point
     * @param y the y coordinate end point
     * @param name the name to identify CheckPoint
     */
    public CheckPoint(double controlX,
                      double controlY,
                      double x,
                      double y,
                      String name) {
        super(controlX, controlY, x, y);
        this.name = name;
    }

    /**
     * the name of the used to identify the CheckPoint
     * @return name
     */
    public String getName(){
        return name;
    }
}
