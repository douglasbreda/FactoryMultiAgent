/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.agent;

import jade.core.Agent;
import model.Factory;
import model.behaviour.supervisor.CallRobot;
import model.behaviour.supervisor.CallTruck;
import model.behaviour.supervisor.Controller;

/**
 *
 * @author dougl
 */
public class Supervisor extends Agent{
    
    Factory oFactory = new Factory();

    public Supervisor(Factory pFactory) {
        this.oFactory = pFactory;
    }
    
     @Override
    protected void setup(){
         System.out.println("Oi, sou o Supervisor e estou pronto para iniciar a produção!");
    }
    
    //Inicia o comportamento que fica rodando e controlando a fábrica
    public void StartController(){
        this.addBehaviour(new Controller(this.oFactory));
    }
    
    //Chama os robôs
    public void CallRobot(){
        this.addBehaviour(new CallRobot());
    }
    
    //Chama o caminhão
    public void CallTruck(){
        this.addBehaviour(new CallTruck());
    }
}
