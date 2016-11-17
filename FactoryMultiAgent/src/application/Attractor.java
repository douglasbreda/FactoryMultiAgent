/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.scene.Node;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author dougl
 */
public class Attractor extends Sprite {
    public Attractor(Layer layer, Vector2D location, Vector2D velocity, Vector2D acceleration, double width, double height) {
        super(layer, location, velocity, acceleration, width, height);
    }

    @Override
    public Node createView() {

        //double radius = width / 2;

        
        Rectangle rec = new Rectangle(100,100);

//        rec.setCenterX(radius);
//        rec.setCenterY(radius);

        rec.setStroke(Color.GREEN);
        rec.setFill(Color.GREEN.deriveColor(1, 1, 1, 0.3));
        

        return rec;
    }

}
