package rg.quintana.froggerq;
//                                                    EL BUENO
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    final short SCENE_HEIGHT = 800;
    final short SCENE_WIDTH = 648;
    int ranaHeight = 108;
    int ranaWidht = 128;
    int ranaY = 680;
    int ranaX = ((SCENE_WIDTH - ranaWidht )/2);
    byte ranaDirectionY = 0;
    byte ranaDirectionX = 0;
    byte ranaCurrentSpeed = 4;
    short pasosY= 0;
    short pasosX= 0;
    byte cochesCurrentSpeed = 4;
    int imageViewCocheVerdeX = ((SCENE_WIDTH - ranaWidht )/2);
    int imageViewCocheArcoIrisX = ((SCENE_WIDTH - ranaWidht )/2);
    byte cocheDirectionX = -1;
    
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        var scene = new Scene(root, SCENE_WIDTH,SCENE_HEIGHT );
        stage.setScene(scene);
        stage.show();
        
        
        short cocheverdeHeight = 50;
        short cocheverdePosY = (short) ((SCENE_HEIGHT - cocheverdeHeight)/2);
        byte cocheverdeCurrentSpeed = 2;
        byte cocheverdeDirection = 0;
        
//      Imagen carretera
        Image image1 = new Image(getClass().getResourceAsStream("/images/carreterarana.png")); 
        ImageView imageView1 = new ImageView(image1);
        root.getChildren().add(imageView1);
        
        
//      Imagen rana
        Image rana = new Image (getClass().getResourceAsStream("/images/ranaa.png"));
        ImageView imageViewRana = new ImageView(rana);
        
//      root.getChildren().add(imageView2);
//        imageViewRana.setX (ranaX);
//        imageViewRana.setY(ranaY);
        
//      Rectángulo rana
        Rectangle rectrana = new Rectangle();
        rectrana.setWidth(ranaWidht);
        rectrana.setHeight(ranaHeight);
//        rectrana.setX(ranaX);
//        rectrana.setY(ranaY);
        //root.getChildren().add(rectrana);
        rectrana.setFill(Color.TRANSPARENT);
        
        Group grouprana = new Group ();
        grouprana.getChildren().add(imageViewRana);
        grouprana.getChildren().add(rectrana);  
        root.getChildren().add(grouprana);
        
        
        
//      Imagen cocheverde
        Image cocheverde = new Image (getClass().getResourceAsStream("/images/cocheverde.png"));
        ImageView imageViewCocheVerde = new ImageView(cocheverde);
//        root.getChildren().add(imageViewCocheVerde);
//        imageViewCocheVerde.setX ((SCENE_WIDTH - ranaWidht )/2);
        imageViewCocheVerde.setY(193);
        
//      Rectángulo cocheverde
        Rectangle rectcocheverde = new Rectangle();
        rectcocheverde.setWidth(185);
        rectcocheverde.setHeight(91);
//        rectcocheverde.setX((SCENE_WIDTH - ranaWidht )/2);
        rectcocheverde.setY(193);
//        root.getChildren().add(rectcocheverde);
        rectcocheverde.setFill(Color.TRANSPARENT);
        
        Group groupcocheverde = new Group ();
        groupcocheverde.getChildren().add(imageViewCocheVerde);
        groupcocheverde.getChildren().add(rectcocheverde);  
        root.getChildren().add(groupcocheverde);
        
        Image cochearcoiris = new Image (getClass().getResourceAsStream("/images/cochearcoiris.png"));
        ImageView imageViewCocheArcoIris = new ImageView(cochearcoiris);
        root.getChildren().add(imageViewCocheArcoIris);
        imageViewCocheArcoIris.setX ((SCENE_WIDTH - ranaWidht )/2);
        imageViewCocheArcoIris.setY(320);

        //      Rectángulo rectcochearcoiris
        Rectangle rectcochearcoiris = new Rectangle();
        rectcochearcoiris.setWidth(185);
        rectcochearcoiris.setHeight(91);
        rectcochearcoiris.setX((SCENE_WIDTH - ranaWidht )/2);
        rectcochearcoiris.setY(320);
//        root.getChildren().add(rectcochearcoiris);
        rectcochearcoiris.setFill(Color.RED);
        
        Group groupcochearcoiris = new Group ();
        groupcochearcoiris.getChildren().add(imageViewCocheArcoIris);
        groupcochearcoiris.getChildren().add(rectcochearcoiris);  
        root.getChildren().add(groupcochearcoiris);
        
        
        
        
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
                    
                    grouprana.setLayoutY(ranaY);
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
                    grouprana.setLayoutX(ranaX);
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
                     
                    groupcocheverde.setLayoutX(imageViewCocheVerdeX);
                    imageViewCocheVerdeX +=cochesCurrentSpeed * cocheDirectionX;
                    if(imageViewCocheVerdeX>= 510){
                        cocheDirectionX=-1;
                    } else if (imageViewCocheVerdeX<=0){
                        cocheDirectionX= +1;
                    }
//                    groupcochearcoiris.setLayoutX(imageViewCocheArcoIrisX);
//                    imageViewCocheArcoIrisX +=cochesCurrentSpeed * cocheDirectionX;
//                    if(imageViewCocheArcoIrisX>= 510){
//                        cocheDirectionX=-1;
//                    } else if (imageViewCocheArcoIrisX<=0){
//                        cocheDirectionX= +1;
//                    }
                    
                    Shape shapeCollision = Shape.intersect( rectrana, rectcocheverde);
                    boolean colisionVacia = shapeCollision.getBoundsInLocal().isEmpty();
                    if(colisionVacia == false) {
                        System.out.println("colisiona");
                        ranaY=680;
                        pasosY=31;
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
        