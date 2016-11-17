/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.scene.Node;

/**
 *
 * @author dougl
 */
public class RobotPanel extends Sprite{
    
    private int iState = 1;

    public int getiState() {
        return iState;
    }

    public void setiState(int iState) {
        this.iState = iState;
    }
    
    public RobotPanel(Layer layer, Vector2D location, Vector2D velocity, Vector2D acceleration, double width, double height) {
        super(layer, location, velocity, acceleration, width, height);
    }

    @Override
    public Node createView() {
        return Utils.createArrowImageView( (int) width);
    }
}
