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
    int ranaY = 680;
    int ranaX = ((SCENE_WIDTH - ranaWidht )/2);
    byte ranaDirectionY = 0;
    byte ranaDirectionX = 0;
    byte ranaCurrentSpeed = 4;
    short pasosY= 0;
    short pasosX= 0;
    
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        var scene = new Scene(root, SCENE_WIDTH,SCENE_HEIGHT );
        stage.setScene(scene);
        stage.show();
        
        
//      Imagen carretera
        Image image1 = new Image(getClass().getResourceAsStream("/images/carreterarana.png")); 
        ImageView imageView1 = new ImageView(image1);
        root.getChildren().add(imageView1);
        
        
//      Imagen rana
        Image rana = new Image (getClass().getResourceAsStream("/images/ranaa.png"));
        ImageView imageView2 = new ImageView(rana);
        root.getChildren().add(imageView2);
        imageView2.setX ((SCENE_WIDTH - ranaWidht )/2);
        imageView2.setY(ranaY);
        
//      Imagen coches descargados
        Image cocheverde = new Image (getClass().getResourceAsStream("/images/cocheverde.png"));
        ImageView imageView3 = new ImageView(cocheverde);
        root.getChildren().add(imageView3);
        imageView3.setX ((SCENE_WIDTH - ranaWidht )/2);
        imageView3.setY(193);
        
//      Rectángulo cocheverde
      
//        Image cochearcoiris = new Image (getClass().getResourceAsStream("/images/cochearcoiris.png"));
//        ImageView imageView4 = new ImageView(cochearcoiris);
//        root.getChildren().add(imageView4);
//        imageView4.setX ((SCENE_WIDTH - ranaWidht )/2);
//        imageView4.setY(320);
//        Image cochearcoiris = new Image (getClass().getResourceAsStream("/images/cochearcoiris.png"));
//        
        
        
        
    scene.setOnKeyPressed(new EventHandler <KeyEvent> (){
            public void handle (final KeyEvent keyEvent){
                switch (keyEvent.getCode()) {
                    case UP:
                        ranaDirectionY = -1;
                    break;
                        
                    case DOWN:
                        ranaDirectionY = 1;
                    break;  
                    
                    case LEFT:
                        ranaDirectionX = -1;
                        System.out.println("izq");
                    break;
                        
                    case RIGHT:
                        ranaDirectionX = 1;
                        System.out.println("dere");
                    break;
                }    
            }
    });
    
    Timeline timeline = new Timeline(
            // 0.017 ~= 60 FPS
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
                    
                    imageView2.setY(ranaY);
                    ranaY += ranaCurrentSpeed * ranaDirectionY;
//                  Si se mueve en Y 
                    if (ranaDirectionY != 0){
                    pasosY++;
                    System.out.println(pasosY);
                    }
                    if(ranaY <= 0 || ranaY >= SCENE_HEIGHT-ranaHeight) {
                        ranaDirectionY = 0;
                    }
                    if(ranaY <= 0) {
                        ranaDirectionY = 0;
                        ranaY = 0;
                    }else if (ranaY >= SCENE_HEIGHT-ranaHeight) {
                        ranaDirectionY = 0;
                        ranaY = (short)(SCENE_HEIGHT-ranaHeight);
                    }
                    
//                    que se pare en cada calzada
//                  if (pasos==37 || pasos==70 || pasos==102 || pasos==132
                    if (pasosY==32 ) {
                        ranaDirectionY = 0;
                        pasosY = 0;
                    }
                    
//                  La X de la rana
                    imageView2.setX(ranaX);
                    ranaX += ranaCurrentSpeed * ranaDirectionX;
                    
                    if (ranaDirectionX != 0){
                    pasosX++;
                    System.out.println(pasosX);
                    }
                    if(ranaX <= 0 || ranaX >= SCENE_WIDTH-ranaWidht) {
                        ranaDirectionX = 0;
                    }
                     if(ranaX <= 0) {
                        ranaDirectionX = 0;
                        ranaX = 0;
                    }else if (ranaX >= SCENE_WIDTH-ranaWidht) {
                        ranaDirectionX = 0;
                        ranaX = (short)(SCENE_WIDTH-ranaWidht); 
                    }
                     if (pasosX==20 ) {
                        ranaDirectionX = 0;
                        pasosX = 0;
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
        