package rg.quintana.froggerq;
//                                                    EL BUENO
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    final short SCENE_HEIGHT = 800;
    final short SCENE_WIDTH = 648;
    int ranaHeight = 70;
    int ranaWidht = 80;
    int ranaY = 700;
    int ranaX = ((SCENE_WIDTH - ranaWidht )/2);
    byte ranaDirectionY = 0;
    byte ranaDirectionX = 0;
    byte ranaCurrentSpeed = 4;
    short pasosY= 0;
    short pasosX= 0;
    byte cochesCurrentSpeedVerde = 3;
    int imageViewCocheVerdeX = ((SCENE_WIDTH - ranaWidht )/2);
    int imageViewCocheArcoIrisX = ((SCENE_WIDTH - ranaWidht )/2);
    int imageViewCocheInventadoX = ((SCENE_WIDTH - ranaWidht )/2);
    int imageViewCocheAzulX = ((SCENE_WIDTH - ranaWidht )/2);
    byte cocheDirectionXVerde = -1;
    byte cocheDirectionXArcoIris = +1;
    byte cocheDirectionXInventado = -1;
    byte cocheDirectionXAzul = +1;
    byte cochesCurrentSpeedArcoIris = 3;
    byte cochesCurrentSpeedInventado = 2;
    byte cochesCurrentSpeedAzul = 1;
    final short TEXT_SIZE = 40;
    
    int score = 0;
    Label label = new Label();
    
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
//        root.getChildren().add(rectrana);
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
        rectcocheverde.setWidth(150);
        rectcocheverde.setHeight(73);
//      rectcocheverde.setX((SCENE_WIDTH - ranaWidht )/2);
        rectcocheverde.setY(193);
//      root.getChildren().add(rectcocheverde);
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
        rectcochearcoiris.setWidth(150);
        rectcochearcoiris.setHeight(73);
        rectcochearcoiris.setX((SCENE_WIDTH - ranaWidht )/2);
        rectcochearcoiris.setY(320);
//        root.getChildren().add(rectcochearcoiris);
        rectcochearcoiris.setFill(Color.TRANSPARENT);
        
        Group groupcochearcoiris = new Group ();
        groupcochearcoiris.getChildren().add(imageViewCocheArcoIris);
        groupcochearcoiris.getChildren().add(rectcochearcoiris);  
        root.getChildren().add(groupcochearcoiris);
        
//      Rectángulo rectcocheinventado
        Rectangle rectcocheinventado = new Rectangle();
        Rectangle rectcocheinventadoluzarriba = new Rectangle();
        Rectangle rectcocheinventadoluzabajo = new Rectangle();
        Rectangle rectcocheinventadoluzfrenoarriba = new Rectangle();
        Rectangle rectcocheinventadoluzfrenoabajo = new Rectangle();
        Rectangle rectcocheinventadocristaldelante = new Rectangle();

        
//      Tamaños de los rectángulos inventados
        rectcocheinventado.setWidth(150);
        rectcocheinventado.setHeight(73);
        rectcocheinventadoluzarriba.setWidth(7);
        rectcocheinventadoluzarriba.setHeight(10);
        rectcocheinventadoluzabajo.setWidth(7);
        rectcocheinventadoluzabajo.setHeight(10);
        rectcocheinventadoluzfrenoarriba.setWidth(7);
        rectcocheinventadoluzfrenoarriba.setHeight(10);
        rectcocheinventadoluzfrenoabajo.setWidth(7);
        rectcocheinventadoluzfrenoabajo.setHeight(10);
        rectcocheinventadocristaldelante.setWidth(20);
        rectcocheinventadocristaldelante.setHeight(45);
        
//      Posición de los rectángulos
        rectcocheinventado.setX((SCENE_WIDTH - ranaWidht )/2);
        rectcocheinventado.setY(450);
        rectcocheinventadoluzarriba.setX((SCENE_WIDTH - ranaWidht )/2);
        rectcocheinventadoluzarriba.setY(460);
        rectcocheinventadoluzabajo.setX((SCENE_WIDTH - ranaWidht )/2);
        rectcocheinventadoluzabajo.setY(503);
        rectcocheinventadoluzfrenoarriba.setX (((SCENE_WIDTH + ranaWidht )/2)+(15));
        rectcocheinventadoluzfrenoarriba.setY(450);
        rectcocheinventadoluzfrenoabajo.setX (((SCENE_WIDTH + ranaWidht )/2)+(15));
        rectcocheinventadoluzfrenoabajo.setY(513);
        rectcocheinventadocristaldelante.setX (((SCENE_WIDTH - ranaWidht )/2)+(30));
        rectcocheinventadocristaldelante.setY(465);
        
//      Meter en pantalla
//        root.getChildren().add(rectcocheinventado);
//        root.getChildren().add(rectcocheinventadoluzarriba);
//        root.getChildren().add(rectcocheinventadoluzabajo);
//        root.getChildren().add(rectcocheinventadoluzfrenoarriba);
//        root.getChildren().add(rectcocheinventadoluzfrenoabajo);
//        root.getChildren().add(rectcocheinventadocristaldelante);
        
//      Colores a rellenar
        rectcocheinventado.setFill(Color.CYAN);
        rectcocheinventadoluzarriba.setFill(Color.YELLOW);
        rectcocheinventadoluzabajo.setFill(Color.YELLOW);
        rectcocheinventadoluzfrenoarriba.setFill(Color.RED);
        rectcocheinventadoluzfrenoabajo.setFill(Color.RED);
        rectcocheinventadocristaldelante.setFill(Color.DIMGRAY);

        Group groupcocheinventado = new Group ();
        groupcocheinventado.getChildren().add(rectcocheinventado);
        groupcocheinventado.getChildren().add(rectcocheinventadoluzarriba);
        groupcocheinventado.getChildren().add(rectcocheinventadoluzabajo);
        groupcocheinventado.getChildren().add(rectcocheinventadoluzfrenoarriba);
        groupcocheinventado.getChildren().add(rectcocheinventadoluzfrenoabajo);
        groupcocheinventado.getChildren().add(rectcocheinventadocristaldelante);
        root.getChildren().add(groupcocheinventado);
        
        
//      Imagen cocheazul
        Image cocheazul = new Image (getClass().getResourceAsStream("/images/cocheazul.png"));
        ImageView imageViewCocheAzul = new ImageView(cocheazul);
        root.getChildren().add(imageViewCocheAzul);
        imageViewCocheAzul.setX ((SCENE_WIDTH - ranaWidht )/2);
        imageViewCocheAzul.setY(575);
        
//      Rectángulo cocheverde
        Rectangle rectcocheazul = new Rectangle();
        rectcocheazul.setWidth(150);
        rectcocheazul.setHeight(74);
        rectcocheazul.setX((SCENE_WIDTH - ranaWidht )/2);
        rectcocheazul.setY(575);
//      root.getChildren().add(rectcocheverde);
        rectcocheazul.setFill(Color.TRANSPARENT);
//        
        Group groupcocheazul = new Group ();
        groupcocheazul.getChildren().add(imageViewCocheAzul);
        groupcocheazul.getChildren().add(rectcocheazul);  
        root.getChildren().add(groupcocheazul);
        
//      Puntuaciones
        label.relocate(10, 8);
        label.setTextFill(RED);
//        HACER LO DEL STACK PANE
        label.setFont(Font.font(TEXT_SIZE));
        root.getChildren().add(label);
        
//        
//        HBox paneScores = new HBox ();
//        paneScores.setf;
//        paneScores.setTranslateY(8);
//        paneScores.setAlignment(Pos.CENTER);
//        root.getChildren().add(paneScores);


        
        
//      Reconocimiento de teclas
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
    
//  Animación
    Timeline timeline = new Timeline(
            // 0.017 ~= 60 FPS
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
                    
                    label.setText("SCORE=  " + score);
                    
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
                            
//                    Que se pare en cada calzada
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
//                    Movimiento del coche verde
                    groupcocheverde.setLayoutX(imageViewCocheVerdeX);
                    imageViewCocheVerdeX +=cochesCurrentSpeedVerde * cocheDirectionXVerde;
                    if(imageViewCocheVerdeX>= 510){
                        cocheDirectionXVerde=-1;
                    } else if (imageViewCocheVerdeX<=0){
                        cocheDirectionXVerde= +1;
                    }
//                    Movimiento del coche arco iris
                    groupcochearcoiris.setLayoutX(imageViewCocheArcoIrisX);
                    imageViewCocheArcoIrisX +=cochesCurrentSpeedArcoIris * cocheDirectionXArcoIris;
                    if(imageViewCocheArcoIrisX>= 250){
                        cocheDirectionXArcoIris=-1;
                    } else if (imageViewCocheArcoIrisX<=-270){
                        cocheDirectionXArcoIris= +1;
                    }
//                   Movimiento del coche inventado
                    groupcocheinventado.setLayoutX(imageViewCocheInventadoX);
                    imageViewCocheInventadoX +=cochesCurrentSpeedInventado * cocheDirectionXInventado;
                    if(imageViewCocheInventadoX>= 250){
                        cocheDirectionXInventado=-1;
                    } else if (imageViewCocheInventadoX<=-270){
                        cocheDirectionXInventado= +1;
                    }
//                  Movimiento del coche azul
                    groupcocheazul.setLayoutX(imageViewCocheAzulX);
                    imageViewCocheAzulX +=cochesCurrentSpeedAzul * cocheDirectionXAzul;
                    if(imageViewCocheAzulX>= 250){
                        cocheDirectionXAzul=-1;
                    } else if (imageViewCocheAzulX<=-270){
                        cocheDirectionXAzul= +1;
                    }
//                    Colisión entre la rana y el coche verde
                    Shape shapeCollisionVerde = Shape.intersect( rectrana, rectcocheverde);
                    boolean colisionVaciaVerde = shapeCollisionVerde.getBoundsInLocal().isEmpty();
                    if(colisionVaciaVerde == false) {
                        System.out.println("colisionaVerde");
                        ranaY=700;
                        pasosY=31;
                    }
//                    Colisión entre la rana y el coche arco iris
                    Shape shapeCollisionArcoIris = Shape.intersect( rectrana, rectcochearcoiris);
                    boolean colisionVaciaArcoIris = shapeCollisionArcoIris.getBoundsInLocal().isEmpty();
                    if(colisionVaciaArcoIris == false) {
                        System.out.println("colisionaArcoIris");
                        ranaY=700;
                        pasosY=31;
                    }
//                  Colisión entre la rana y el coche inventado
                    Shape shapeCollisionInventado = Shape.intersect( rectrana, rectcocheinventado);
                    boolean colisionVaciaInventado = shapeCollisionInventado.getBoundsInLocal().isEmpty();
                    if(colisionVaciaInventado == false) {
                        System.out.println("colisionaInventado");
                        ranaY=700;
                        pasosY=31;
                    }
//                  Colisión entre la rana y el coche azul
                    Shape shapeCollisionAzul = Shape.intersect( rectrana, rectcocheazul);
                    boolean colisionVaciaAzul = shapeCollisionAzul.getBoundsInLocal().isEmpty();
                    if(colisionVaciaAzul == false) {
                        System.out.println("colisionaAzul");
                        ranaY=700;
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
        