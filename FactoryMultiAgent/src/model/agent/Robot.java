/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.agent;

import jade.core.Agent;
import model.behaviour.robot.RobotBehaviours;

/**
 * 
 * @author dougl
 */
public class Robot extends Agent{
    
    @Override
    protected void setup(){
        System.out.println("Oi, sou o robô, estou pronto...");
        RobotBehaviours oRobotBehaviour = new RobotBehaviours();
        oRobotBehaviour.StartBehaviours();
        oRobotBehaviour.SetTransitions();
        this.addBehaviour(oRobotBehaviour);
        
    }
}
