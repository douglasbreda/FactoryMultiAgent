/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.agent;

import jade.core.Agent;
import model.behaviour.robot.Charge;
import model.behaviour.robot.GoLoadPoint;
import model.behaviour.robot.GoStartPoint;
import model.behaviour.robot.GoTruck;
import model.behaviour.robot.Uncharge;


/**
 * 
 * @author dougl
 */
public class Robot extends Agent{
    
    @Override
    protected void setup(){
        
    }
    
    //Chamada quando o robô carrega o pallet
    public void Charge(){
        this.addBehaviour(new Charge());
    }
    
    //Vai para o ponto de carga
    public void GoLoadPoint(){
        this.addBehaviour(new GoLoadPoint());
    }
    
    //Volta ao ponto inicial
    public void GoStarPoint(){
        this.addBehaviour(new GoStartPoint());
    }
            
    //Leva o pallet até o caminhão
    public void GoTruck(){
        this.addBehaviour(new GoTruck());
    }
            
    //Descarrega o pallet do robô
    public void Uncharge(){
        this.addBehaviour(new Uncharge());
    }
}
