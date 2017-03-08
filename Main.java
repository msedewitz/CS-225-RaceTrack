
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

public class Main extends Application {
    Stage stage = new Stage();
    BorderPane pane = new BorderPane();
    VBox instructions = new VBox();
    Button start, restart, quit, displayStats;
    Label directions, instructionHeader;
    ImageView image0, image1, image2, image3;
    Image imageA = new Image("carBlue.png");
    Image imageB = new Image("carGreen.png");
    Image imageC = new Image("carRed.png");
    Image imageD = new Image("carYellow.png");
    Car[] cars = new Car[4];
    double speed0, speed1, speed2, speed3;
    private Alert stats;
    Boolean inGame = true;

    Venue venue = new Venue();

    @Override
    public void start(Stage primaryStage) throws Exception{
        cars[0] = new Car(100, 280,imageA);
        cars[1] = new Car(316, 144,imageB);
        cars[2] = new Car(527, 287,imageC);
        cars[3] = new Car(345, 495,imageD);
        cars[0].setName("Blue Car");
        cars[1].setName("Green Car");
        cars[2].setName("Red Car");
        cars[3].setName("Yellow Car");

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

        Group groupCenter = new Group();
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setLayoutX(500);
        grid.setLayoutY(500);

        groupCenter.getChildren().addAll(grid);
        Path path0 = new Path();
        path0.setStrokeWidth(100);
        path0.setFill(Color.ALICEBLUE);
        path0.getElements().add(new MoveTo(100, 280));
        path0.getElements().addAll(  venue.getCheckPoints(0),
                venue.getCheckPoints(1),
                venue.getCheckPoints(2),
                venue.getCheckPoints(3));

        Path path1 = new Path();
//        path1.setStrokeWidth(30);
        path1.getElements().addAll(new MoveTo(316, 144));
        path1.getElements().addAll(venue.getCheckPoints(1),
                venue.getCheckPoints(2),
                venue.getCheckPoints(3),
                venue.getCheckPoints(0));

        Path path2 = new Path();
//        path2.setStrokeWidth(30);
        path2.getElements().addAll(new MoveTo(527, 287));
        path2.getElements().addAll(venue.getCheckPoints(2),
                venue.getCheckPoints(3),
                venue.getCheckPoints(0),
                venue.getCheckPoints(1));

        Path path3 = new Path();
//        path3.setStrokeWidth(30);
        path3.getElements().addAll(new MoveTo(345, 495));
        path3.getElements().addAll(venue.getCheckPoints(3),
                venue.getCheckPoints(0),
                venue.getCheckPoints(1),
                venue.getCheckPoints(2));

        image0 = new ImageView(cars[0].getCarImage());
        image0.setX(100);
        image0.setY(280);
        image0.setFitHeight(50);
        image0.setFitWidth(50);

        image1 = new ImageView(cars[1].getCarImage());
        image1.setX(316);
        image1.setY(144);
        image1.setFitHeight(50);
        image1.setFitWidth(50);


        image2 = new ImageView(cars[2].getCarImage());
        image2.setX(527);
        image2.setY(287);
        image2.setFitHeight(50);
        image2.setFitWidth(50);

        image3 = new ImageView(cars[3].getCarImage());
        image3.setX(345);
        image3.setY(495);
        image3.setFitHeight(50);
        image3.setFitWidth(50);

        start.setOnAction(e -> {
            cars[0].calcSpeed();
            speed0 = cars[0].getSpeed();
            PathTransition pathTransition0 = new PathTransition();
            pathTransition0.setDuration(Duration.seconds(speed0));
            pathTransition0.setPath(path0);
            pathTransition0.setNode(image0);
            //setOrientation get the car on track
            pathTransition0.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            pathTransition0.setCycleCount(1);

            cars[1].calcSpeed();
            PathTransition pathTransition1 = new PathTransition();
            speed1 = cars[1].getSpeed();
            pathTransition1.setDuration(Duration.seconds(speed1));
            pathTransition1.setPath(path1);
            pathTransition1.setNode(image1);
            pathTransition1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            pathTransition1.setCycleCount(1);

            cars[2].calcSpeed();
            PathTransition pathTransition2 = new PathTransition();
            speed2 = cars[2].getSpeed();
            pathTransition2.setDuration(Duration.seconds(speed2));
            pathTransition2.setPath(path2);
            pathTransition2.setNode(image2);
            pathTransition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            pathTransition2.setCycleCount(1);

            cars[3].calcSpeed();
            PathTransition pathTransition3 = new PathTransition();
            speed3 = cars[3].getSpeed();
            pathTransition3.setDuration(Duration.seconds(speed3));
            pathTransition3.setPath(path3);
            pathTransition3.setNode(image3);
            pathTransition3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            pathTransition3.setCycleCount(1);

            pathTransition0.play();
            pathTransition1.play();
            pathTransition2.play();
            pathTransition3.play();


            System.out.println("speed 0 :" + speed0  +
                    "\nspeed 1: " +speed1 +
                    "\nspeed 2 : " + speed2 +
                    "\nspeed 3 : " +speed3);
        });

        displayStats.setOnAction(e -> {
            stats = new Alert(Alert.AlertType.INFORMATION);
            stats.setHeaderText("Car Statistics");
            stats.setContentText(cars[0].toString());
            stats.showAndWait();
        });
        /*      */

        Text text0 = new Text(  venue.getCheckPoints(3).getX(),
                venue.getCheckPoints(3).getY(),
                venue.getCheckPoints(0).getName());
        Text text1 = new Text(  venue.getCheckPoints(0).getX(),
                venue.getCheckPoints(0).getY(),
                venue.getCheckPoints(1).getName());
        Text text2 = new Text(  venue.getCheckPoints(1).getX(),
                venue.getCheckPoints(1).getY(),
                venue.getCheckPoints(2).getName());
        Text text3 = new Text(  venue.getCheckPoints(2).getX(),
                venue.getCheckPoints(2).getY(),
                venue.getCheckPoints(3).getName());

        text0.setFill(Color.GREEN);
        text0.setStyle("-fx-font: 45 arial;");
        text1.setFill(Color.GREEN);
        text1.setStyle("-fx-font: 45 arial;");
        text2.setFill(Color.GREEN);
        text2.setStyle("-fx-font: 45 arial;");
        text3.setFill(Color.GREEN);
        text3.setStyle("-fx-font: 45 arial;");

        groupCenter.getChildren().addAll(path0, path1, path2, path3,
                text0, text1, text2, text3,
                image0, image1, image2, image3);

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
