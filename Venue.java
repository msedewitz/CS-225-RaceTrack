/*
 * Sergio De Sa
 */

package sample;


public class Venue {
    private Car[] cars;
    private CheckPoint[] checkPoints;

    public Venue(){
        cars = new Car[4];
        checkPoints = new CheckPoint[4];

        cars[0] = new Car(100, 280);
        cars[1] = new Car(316, 144);
        cars[2] = new Car(527, 287);
        cars[3] = new Car(345, 495);

        checkPoints[0] = new CheckPoint( 100, 100, 316, 144, "A");
        checkPoints[1] = new CheckPoint( 500, 200, 527, 287, "B");
        checkPoints[2] = new CheckPoint( 500, 500, 345, 495, "C");
        checkPoints[3] = new CheckPoint( 75, 500, 100, 280, "D");


    }
    public CheckPoint getCheckPoints(int value){
        return checkPoints[value];
    }
}
