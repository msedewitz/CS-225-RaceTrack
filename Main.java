/*
 * Sergio De Sa
 */

package Project3;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.awt.*;

public class Main extends Application {
    Stage stage = new Stage();
    BorderPane pane = new BorderPane();
    VBox instructions = new VBox();
    Button start, restart, quit, displayStats;
    Label directions, instructionHeader;

    Venue venue = new Venue();

    @Override
    public void start(Stage primaryStage) throws Exception{

        createTopToolBar();
        createInstructions();
        createCenterToolBar();

        Rectangle2D rec = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(pane, rec.getWidth(), rec.getHeight());
        stage.setTitle("Logic Puzzle Game");
        stage.setScene(scene);
        stage.show();

    }

    public void createTopToolBar(){
        HBox topToolBar = new HBox();
        topToolBar.setPadding(new Insets(20));
        topToolBar.setSpacing(50);
        topToolBar.setAlignment(Pos.TOP_CENTER);

        start = new Button("Start");
        restart = new Button("Restart");
        quit = new Button("Quit");
        displayStats = new Button ("Display Statistics");

        topToolBar.getChildren().addAll(start,restart,quit,displayStats);
        pane.setTop(topToolBar);

    }
    public void createCenterToolBar(){
        Car[] cars = new Car[4];
        ImageView image1, image2, image3,image4;
        Image image = new Image("car1.png");


        Group groupCenter = new Group();
        GridPane grid = new GridPane();

        grid.setGridLinesVisible(true);
        grid.setLayoutX(500);
        grid.setLayoutY(500);

        groupCenter.getChildren().addAll(grid);

        Path path = new Path();
        path.setStrokeWidth(30);
        path.setFill(Color.ALICEBLUE);

        cars[0] = new Car(100, 280,image);
        cars[1] = new Car(316, 144,image);
        cars[2] = new Car(527, 287,image);
        cars[3] = new Car(345, 495,image);

        image1 = new ImageView(cars[0].getCarImage());
        image1.setX(80);
        image1.setY(250);


        path.getElements().add(new MoveTo(100, 280));
        path.getElements().addAll(  venue.getCheckPoints(0),
                venue.getCheckPoints(1),
                venue.getCheckPoints(2),
                venue.getCheckPoints(3));

        /*    */
        PathTransition pathTransition = new PathTransition();

        double speed = cars[0].getSpeed();

        pathTransition.setDuration(Duration.seconds(speed));
        pathTransition.setPath(path);
        pathTransition.setNode(image1);

        //setOrientation get the car on track
        pathTransition.setOrientation
                (PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(1);
        pathTransition.play();

        /*      */

        Text text0 = new Text(  venue.getCheckPoints(3).getX() + 20,
                venue.getCheckPoints(3).getY() + 20,
                venue.getCheckPoints(0).getName());
        Text text1 = new Text(  venue.getCheckPoints(0).getX() - 30,
                venue.getCheckPoints(0).getY() - 30,
                venue.getCheckPoints(1).getName());
        Text text2 = new Text(  venue.getCheckPoints(1).getX() + 20,
                venue.getCheckPoints(1).getY() + 20,
                venue.getCheckPoints(2).getName());
        Text text3 = new Text(  venue.getCheckPoints(2).getX() + 20,
                venue.getCheckPoints(2).getY() + 20,
                venue.getCheckPoints(3).getName());

        groupCenter.getChildren().addAll(path, text0, text1, text2, text3, image1);

        pane.setCenter(groupCenter);

    }


    public void createInstructions(){
        instructions.setPadding(new Insets(10,10,10,10));

        instructionHeader = new Label("                        How To Play!\n\n");
        directions = new Label ("    Select 'Start' to begin the race simulator\n" +
                "    four cars will be displayed on four different\n" +
                "    checkpoints, A, B, C, D. The car that crosses\n" +
                "    all of the checkpoints the fastest will win.\n" +
                "    Once the race is completed each cars \n    racing statistics" +
                "will be displayed in \n    the bottom section of the window.");
        instructions.getChildren().addAll(instructionHeader,directions);
        pane.setLeft(instructions);

    }



    public static void main(String[] args) {
        launch(args);
    }
}