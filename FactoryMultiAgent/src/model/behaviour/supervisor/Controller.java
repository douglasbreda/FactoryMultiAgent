/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.behaviour.supervisor;

import jade.core.behaviours.CyclicBehaviour;
import model.Factory;

/**
 *
 * @author dougl
 */
public class Controller extends CyclicBehaviour{

    private Factory oFactory = null;

    
    public Controller(Factory pFactory) {
        this.oFactory = pFactory;
    }
    
    @Override
    public void action() {
        
    }
    
}
