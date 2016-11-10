/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.agent;

import jade.core.Agent;
import model.AgentFactory;
import model.Factory;
import model.behaviour.supervisor.CallRobot;
import model.behaviour.supervisor.CallTruck;


/**
 *
 * @author dougl
 */
public class Supervisor extends Agent{

    private Factory oFactory = null;
   
     @Override
    protected void setup(){
        oFactory = new Factory();
        oFactory.StartProduction();
        System.out.println("Oi, sou o Supervisor e estou pronto para iniciar a produção!");
        CallRobot();
        //CallTruck();
    }
    
    public void setoFactory(Factory oFactory) {
        this.oFactory = oFactory;
    }
    
    //Chama os robôs
    public void CallRobot(){
        new AgentFactory().CreateAgent("Robô 1", model.agent.Robot.class.getName());
        //this.addBehaviour(new CallRobot());
    }
    
    //Chama o caminhão
    public void CallTruck(){
        this.addBehaviour(new CallTruck());
    }
}
