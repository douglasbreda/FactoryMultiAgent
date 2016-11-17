/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.CentralController;

/**
 *
 * @author dougl
 */
public class Main extends Application {

    static Random random = new Random();

    static Layer playfield;

    static List<Attractor> allAttractors = new ArrayList<>();
    static List<Vehicle> allVehicles = new ArrayList<>();
    static List<RobotPanel> allRobots = new ArrayList<>();

    AnimationTimer gameLoop;

    Vector2D mouseLocation = new Vector2D(0, 0);

    Scene scene;

    MouseGestures mouseGestures = new MouseGestures();

    @Override
    public void start(Stage primaryStage) {

        // create containers
        BorderPane root = new BorderPane();

        // playfield for our Sprites
        playfield = new Layer(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

        // entire game as layers
        Pane layerPane = new Pane();

        layerPane.getChildren().addAll(playfield);

        root.setCenter(layerPane);

        Background oback = new Background(new BackgroundImage(new Image(Main.class.getResource("Industria.png").toExternalForm()), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
        root.setBackground(oback);
        scene = new Scene(root, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();

        // add content
        //prepareGame();
        // add mouse location listener
        addListeners();

        //Inicia uma fábrica
        StartFactory();
        
        //Inicia a animação
        startGame();
    }
    
    //Inicia a fábrica
    private void StartFactory(){
        CentralController oCentralController = new CentralController();
        oCentralController.Start();
    }

    private void prepareGame() {

        // add vehicles
        for (int i = 0; i < 1/*Settings.VEHICLE_COUNT*/; i++) {
            addTrucks();
        }

        // add attractors
        for (int i = 0; i < Settings.ATTRACTOR_COUNT; i++) {
            addAttractors();
        }

        for (int i = 0; i < 1; i++) {
            addRobots();
        }

    }

    private void startGame() {

        // start game
        gameLoop = new AnimationTimer() {

            @Override
            public void handle(long now) {

                if (allAttractors.size() > 0) {
                    // currently we have only 1 attractor
                    Attractor attractorTruck = allAttractors.get(0);

                    // seek attractor location, apply force to get towards it
                    allVehicles.forEach(vehicle -> {

                        vehicle.seek(attractorTruck.getLocation());

                    });

                    // move sprite
                    allVehicles.forEach(Sprite::move);

                    // update in fx scene
                    allVehicles.forEach(Sprite::display);
                    allAttractors.forEach(Sprite::display);
                }
                /*-----------------------------------------------------------------------------*/

                if (allRobots.size() > 0) {
                    //Attractor attractorRobot = allAttractors.get(1);
                    allRobots.forEach(robot -> {
                        Attractor attractorRobot = allAttractors.get(robot.getiState());
                        System.out.println("Robô: " + robot.getLocation().x + "/" + robot.getLocation().y);
                        System.out.println("Attractor: " + attractorRobot.getLocation().x + "/" + attractorRobot.getLocation().y);
                        if ((int) robot.getLocation().x == (int) attractorRobot.getLocation().x
                                && (int) robot.getLocation().y == (int) attractorRobot.getLocation().y) {
                            robot.setiState(robot.getiState() + 1);
                            if (robot.getiState() < allAttractors.size()) {
                                allAttractors.get(robot.getiState());
                            } else {
                                robot.setiState(robot.getiState() - 1);
                            }
                        } else {
                            robot.seek(attractorRobot.getLocation());
                        }

                    });

                    allRobots.forEach(Sprite::move);

                    // update in fx scene
                    allRobots.forEach(Sprite::display);
                    allAttractors.forEach(Sprite::display);
                }
            }
        };

        gameLoop.start();

    }

    /**
     * Add single vehicle to list of vehicles and to the playfield
     */
    public static void addTrucks() {

        Layer layer = playfield;

        double x = 1075;//random.nextDouble() * layer.getWidth();
        double y = 600;//random.nextDouble() * layer.getHeight();

        // dimensions
        double width = 50;
        double height = width / 2.0;

        // create vehicle data
        Vector2D location = new Vector2D(x, y);
        Vector2D velocity = new Vector2D(0, 0);
        Vector2D acceleration = new Vector2D(0, 0);

        // create sprite and add to layer
        Vehicle vehicle = new Vehicle(layer, location, velocity, acceleration, width, height);

        // register vehicle
        allVehicles.add(vehicle);

    }

    public static void addRobots() {
        Layer layer = playfield;

        double x = 875;//random.nextDouble() * layer.getWidth();
        double y = 600;//random.nextDouble() * layer.getHeight();

        // dimensions
        double width = 50;
        double height = width / 2.0;

        // create vehicle data
        Vector2D location = new Vector2D(x, y);
        Vector2D velocity = new Vector2D(0, 0);
        Vector2D acceleration = new Vector2D(0, 0);

        // create sprite and add to layer
        RobotPanel robot = new RobotPanel(layer, location, velocity, acceleration, width, height);

        // register vehicle
        allRobots.add(robot);
    }

    private static void addAttractors() {

        //Attractor for robots 1 (LoadPoint)
        Layer layerRobotAfterLoad = playfield;

        /*---------------------------------------------------------------------------------------------------------------------*/
        // 1º ponto do robô
        double xRobotAfterLoad = layerRobotAfterLoad.getWidth() - 200;
        double yRobotAfterLoad = 290;//layer.getHeight();

        // dimensions
        double widthAfterLoad = 100;
        double heightAfterLoad = 100;

        // create attractor data
        Vector2D locationRobotAfterLoad = new Vector2D(xRobotAfterLoad, yRobotAfterLoad);
        Vector2D velocityRobotAfterLoad = new Vector2D(0, 0);
        Vector2D accelerationRobotAfterLoad = new Vector2D(0, 0);

        // create attractor and add to layer
        Attractor attractorRobotAfterLoad = new Attractor(layerRobotAfterLoad, locationRobotAfterLoad, velocityRobotAfterLoad, accelerationRobotAfterLoad, widthAfterLoad, heightAfterLoad);

        // register sprite
        allAttractors.add(attractorRobotAfterLoad);
        /*-------------------------------------------------------------------------------------------------------------------*/
        //Attractor for trucks
        Layer layer = playfield;

        // center attractor
        double x = 370;//layer.getWidth() - 100;
        double y = layer.getHeight() - 160;

        // dimensions
        double width = 100;
        double height = 100;

        // create attractor data
        Vector2D location = new Vector2D(x, y);
        Vector2D velocity = new Vector2D(0, 0);
        Vector2D acceleration = new Vector2D(0, 0);

        // create attractor and add to layer
        Attractor attractor = new Attractor(layer, location, velocity, acceleration, width, height);

        // register sprite
        allAttractors.add(attractor);

        /*---------------------------------------------------------------------*/
        //2º ponto do robo
        Layer layerRobotLoad = playfield;

        // center attractor
        double xRobotLoad = 370;//layerRobotLoad.getWidth() - 100;
        double yRobotLoad = 290;//layer.getHeight();

        // dimensions
        double widthLoad = 100;
        double heightLoad = 100;

        // create attractor data
        Vector2D locationRobotLoad = new Vector2D(xRobotLoad, yRobotLoad);
        Vector2D velocityRobotLoad = new Vector2D(0, 0);
        Vector2D accelerationRobotLoad = new Vector2D(0, 0);

        // create attractor and add to layer
        Attractor attractorRobotLoad = new Attractor(layerRobotLoad, locationRobotLoad, velocityRobotLoad, accelerationRobotLoad, widthLoad, heightLoad);

        allAttractors.add(attractorRobotLoad);

        /*--------------------------------------------------------------------------------*/
        //Attractor for robots 1 (LoadPoint)
        Layer layerRobotLast = playfield;

        // center attractor
        double xRobotLast = 850;//layerRobotLoad.getWidth() - 100;
        double yRobotLast = 290;//layer.getHeight();

        // dimensions
        double widthLast = 100;
        double heightLast = 100;

        // create attractor data
        Vector2D locationRobotLast = new Vector2D(xRobotLast, yRobotLast);
        Vector2D velocityRobotLast = new Vector2D(0, 0);
        Vector2D accelerationRobotLast = new Vector2D(0, 0);

        // create attractor and add to layer
        Attractor attractorRobotLast = new Attractor(layerRobotLast, locationRobotLast, velocityRobotLast, accelerationRobotLast, widthLast, heightLast);

        allAttractors.add(attractorRobotLast);

    }

    private void addListeners() {

        // capture mouse position
        scene.addEventFilter(MouseEvent.ANY, e -> {
            mouseLocation.set(e.getX(), e.getY());
        });

        // move attractors via mouse
        for (Attractor attractor : allAttractors) {
            mouseGestures.makeDraggable(attractor);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
