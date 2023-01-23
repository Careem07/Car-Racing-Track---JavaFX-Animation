package org.example.lab3;

import java.applet.AudioClip;

import javax.print.attribute.standard.Media;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Path path = new Path(new MoveTo(200, 50),
            new HLineTo(200),
            new LineTo(300, 200),
            new HLineTo(400),
            new ArcTo(50, 50, 0, 410, 50, false, false),
            new HLineTo(310),
            new LineTo(200, 200),
            new HLineTo(100),
            new ArcTo(50, 50, 0,100, 50, false, true),
            new ClosePath());

        path.setStrokeDashOffset(5);
        path.setStroke(Color.WHITE);
        path.getStrokeDashArray().addAll(10.0,10.0);
        path.setStrokeLineCap(StrokeLineCap.ROUND);

        Path color = new Path(new MoveTo(200, 50),
            new HLineTo(200),
            new LineTo(300, 200),
            new HLineTo(400),
            new ArcTo(50, 50, 0, 410, 50, false, false),
            new HLineTo(310),
            new LineTo(200, 200),
            new HLineTo(100),
            new ArcTo(50, 50, 0,100, 50, false, true),
            new ClosePath());

        Path color2 = new Path(new MoveTo(200, 50),
            new HLineTo(200),
            new LineTo(300, 200),
            new HLineTo(400),
            new ArcTo(50, 50, 0, 410, 50, false, false),
            new HLineTo(310),
            new LineTo(200, 200),
            new HLineTo(100),
            new ArcTo(50, 50, 0,100, 50, false, true),
            new ClosePath());

        
        color.setStroke(Color.PURPLE);
        color.setStrokeWidth(50);
        color2.setStroke(Color.BLACK);
        color2.setStrokeWidth(25);

        
      

        ImageView firstCar = new ImageView(new Image(getClass().getResourceAsStream("/Images/car1.png")));
        firstCar.setFitWidth(50);
        firstCar.setFitHeight(50);
        ImageView secondCar = new ImageView(new Image(getClass().getResourceAsStream("/Images/car2.png")));
        secondCar.setFitWidth(50);
        secondCar.setFitHeight(50);

        PathTransition pathTransitionFirstCar = new PathTransition();
        pathTransitionFirstCar.setDuration(Duration.seconds(10));
        pathTransitionFirstCar.setNode(firstCar);
        
        pathTransitionFirstCar.setPath(path);
        pathTransitionFirstCar.setCycleCount(Timeline.INDEFINITE);
        pathTransitionFirstCar.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionFirstCar.play();

        PathTransition pathTransitionSecondCar = new PathTransition();
        pathTransitionSecondCar.setDuration(Duration.seconds(7));
        pathTransitionSecondCar.setNode(secondCar);
        
        pathTransitionSecondCar.setPath(path);
        pathTransitionSecondCar.setCycleCount(Timeline.INDEFINITE);
        pathTransitionSecondCar.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransitionSecondCar.play();
        root.getChildren().addAll(color,color2,path ,firstCar , secondCar);

        firstCar.setOnMouseClicked(e -> pathTransitionFirstCar.setRate(pathTransitionFirstCar.getRate() * -1));
        secondCar.setOnMouseClicked(e -> pathTransitionSecondCar.pause());




        Scene scene = new Scene(root , 500 , 500);
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
    }
}
