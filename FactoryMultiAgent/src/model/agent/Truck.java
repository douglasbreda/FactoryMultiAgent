/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.agent;

import jade.core.Agent;
import model.behaviour.truck.GoCharge;
import model.behaviour.truck.GoDelivery;
import model.behaviour.truck.GoStartPoint;

/**
 * 
 * @author dougl
 */
public class Truck extends Agent{
    
  @Override
    protected void setup(){
        
    } 
    
    //Chama o comportamento que envia o caminhão para o local de carga
    public void GoCharge(){
        this.addBehaviour(new GoCharge());
    }
    
    //Libera o caminhão para fazer a entrega
    public void GoDelivery(){
        this.addBehaviour(new GoDelivery());
    }
    
    //Envia o caminhão para a posição inicial
    public void GoStarPoint(){
        this.addBehaviour(new GoStartPoint());
    }
}
