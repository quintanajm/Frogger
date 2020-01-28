package rg.quintana.froggerq;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    final short SCENE_HEIGHT = 800;
    final short SCENE_WIDTH = 648;
    int ranaHeight = 82;
    int ranaWidht = 101;
    int ranaY = 700;
    byte ranaDirection = 0;
    byte ranaCurrentSpeed = 4;
    short pasos = 0;
    
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        var scene = new Scene(root, SCENE_WIDTH,SCENE_HEIGHT );
        stage.setScene(scene);
        stage.show();
        
        
        
        Image image1 = new Image(getClass().getResourceAsStream("/images/carreterarana.png")); 
        ImageView imageView1 = new ImageView(image1);
        root.getChildren().add(imageView1);
        Image rana = new Image (getClass().getResourceAsStream("/images/ranaa.png"));
        ImageView imageView2 = new ImageView(rana);
        root.getChildren().add(imageView2);
        imageView2.setX ((SCENE_WIDTH - ranaWidht )/2);
        imageView2.setY(ranaY);
    
        
        
    scene.setOnKeyPressed(new EventHandler <KeyEvent> (){
            public void handle (final KeyEvent keyEvent){
                switch (keyEvent.getCode()) {
                    case UP:
                        ranaDirection = -1;
                    break;
                        
                    case DOWN:
                        ranaDirection = 1;
                    break;  
                    
                }    
            }
    });
    Timeline timeline = new Timeline(
            // 0.017 ~= 60 FPS
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
                    imageView2.setY(ranaY);
                    ranaY += ranaCurrentSpeed * ranaDirection;
                    if(ranaY <= 0 || ranaY >= SCENE_HEIGHT-ranaHeight) {
                        ranaDirection = 0;
                        pasos++;
                    }
                     if(ranaY <= 0) {
                        ranaDirection = 0;
                        ranaY = 0;
                         System.out.println(pasos);
                    }else if (ranaY >= SCENE_HEIGHT-ranaHeight) {
                        ranaDirection = 0;
                        ranaY = (short)(SCENE_HEIGHT-ranaHeight);
                        pasos++;
                    }
                }
            })                
        );
            timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();   
    }
    public static void main(String[] args) {
        launch();
    }

}
        