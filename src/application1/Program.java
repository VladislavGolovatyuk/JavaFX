package application1;

import com.sun.org.apache.regexp.internal.RE;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class Program extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        Pane root = new Pane();

        root.getChildren().addAll(generateCircles(15));
        root.getChildren().addAll(generateRectangles(15));

        Button button = new Button();
        button.setTranslateX(20);
        button.setTranslateY(20);
        button.setText("Cleck me!!!");
        button.setOnMouseClicked(event -> {
            root.getChildren().clear();
            root.getChildren().addAll(generateCircles(22));
            root.getChildren().addAll(generateRectangles(22));
            root.getChildren().addAll(button);
        });

        root.getChildren().addAll(button);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private Circle [] generateCircles (int count) {

        Random random = new Random();

        Circle[] circles = new Circle[count];

        for (int i = 0; i < circles.length; i++){
            Color color = Color.color(
                    random.nextDouble(),
                    random.nextDouble(),
                    random.nextDouble(),
                    0.3f);
            circles [i] = new Circle(
                    random.nextInt(400),
                    random.nextInt(400),
                    random.nextInt(80),
                    Paint.valueOf(color.toString()));
        }
        return circles;
    }

    private Rectangle [] generateRectangles (int count) {
        Random random = new Random();

        Rectangle[] rectangles = new Rectangle[count];

        for (int i = 0; i < rectangles.length; i++) {
            Color color = Color.color(
                    random.nextDouble(),
                    random.nextDouble(),
                    random.nextDouble(),
                    0.3f);
            rectangles[i] = new Rectangle(
                    random.nextInt(400),
                    random.nextInt(400),
                    random.nextInt(80), random.nextInt(80));
            rectangles[i].setFill(Paint.valueOf(color.toString()));
        }
        return rectangles;
    }
}
