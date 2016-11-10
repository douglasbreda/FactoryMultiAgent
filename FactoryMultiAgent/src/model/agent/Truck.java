/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.agent;

import jade.core.Agent;
import model.behaviour.truck.TruckBehaviours;

/**
 * 
 * @author dougl
 */
public class Truck extends Agent{
    
    TruckBehaviours oTruckBehaviour = null;
  @Override
    protected void setup(){
        oTruckBehaviour = new TruckBehaviours();
        this.addBehaviour(oTruckBehaviour);
    } 
}
